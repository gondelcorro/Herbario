/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Especie;
import modelo.Genero;
import modelo.Familia;

/**
 *
 * @author DelKo
 */
public class EspecieJpaController implements Serializable {

    public EspecieJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Especie especie) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Genero espIdGen = especie.getEspIdGen();
            if (espIdGen != null) {
                espIdGen = em.getReference(espIdGen.getClass(), espIdGen.getGenId());
                especie.setEspIdGen(espIdGen);
            }
            Familia espIdFam = especie.getEspIdFam();
            if (espIdFam != null) {
                espIdFam = em.getReference(espIdFam.getClass(), espIdFam.getFamId());
                especie.setEspIdFam(espIdFam);
            }
            em.persist(especie);
            if (espIdGen != null) {
                espIdGen.getEspecieList().add(especie);
                espIdGen = em.merge(espIdGen);
            }
            if (espIdFam != null) {
                espIdFam.getEspecieList().add(especie);
                espIdFam = em.merge(espIdFam);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Especie especie) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Especie persistentEspecie = em.find(Especie.class, especie.getEspId());
            Genero espIdGenOld = persistentEspecie.getEspIdGen();
            Genero espIdGenNew = especie.getEspIdGen();
            Familia espIdFamOld = persistentEspecie.getEspIdFam();
            Familia espIdFamNew = especie.getEspIdFam();
            if (espIdGenNew != null) {
                espIdGenNew = em.getReference(espIdGenNew.getClass(), espIdGenNew.getGenId());
                especie.setEspIdGen(espIdGenNew);
            }
            if (espIdFamNew != null) {
                espIdFamNew = em.getReference(espIdFamNew.getClass(), espIdFamNew.getFamId());
                especie.setEspIdFam(espIdFamNew);
            }
            especie = em.merge(especie);
            if (espIdGenOld != null && !espIdGenOld.equals(espIdGenNew)) {
                espIdGenOld.getEspecieList().remove(especie);
                espIdGenOld = em.merge(espIdGenOld);
            }
            if (espIdGenNew != null && !espIdGenNew.equals(espIdGenOld)) {
                espIdGenNew.getEspecieList().add(especie);
                espIdGenNew = em.merge(espIdGenNew);
            }
            if (espIdFamOld != null && !espIdFamOld.equals(espIdFamNew)) {
                espIdFamOld.getEspecieList().remove(especie);
                espIdFamOld = em.merge(espIdFamOld);
            }
            if (espIdFamNew != null && !espIdFamNew.equals(espIdFamOld)) {
                espIdFamNew.getEspecieList().add(especie);
                espIdFamNew = em.merge(espIdFamNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = especie.getEspId();
                if (findEspecie(id) == null) {
                    throw new NonexistentEntityException("The especie with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Especie especie;
            try {
                especie = em.getReference(Especie.class, id);
                especie.getEspId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The especie with id " + id + " no longer exists.", enfe);
            }
            Genero espIdGen = especie.getEspIdGen();
            if (espIdGen != null) {
                espIdGen.getEspecieList().remove(especie);
                espIdGen = em.merge(espIdGen);
            }
            Familia espIdFam = especie.getEspIdFam();
            if (espIdFam != null) {
                espIdFam.getEspecieList().remove(especie);
                espIdFam = em.merge(espIdFam);
            }
            em.remove(especie);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Especie> findEspecieEntities() {
        return findEspecieEntities(true, -1, -1);
    }

    public List<Especie> findEspecieEntities(int maxResults, int firstResult) {
        return findEspecieEntities(false, maxResults, firstResult);
    }

    private List<Especie> findEspecieEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Especie.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Especie findEspecie(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Especie.class, id);
        } finally {
            em.close();
        }
    }

    public int getEspecieCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Especie> rt = cq.from(Especie.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
