/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Familia;
import modelo.Especie;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Genero;

/**
 *
 * @author DelKo
 */
public class GeneroJpaController implements Serializable {

    public GeneroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Genero genero) {
        if (genero.getEspecieList() == null) {
            genero.setEspecieList(new ArrayList<Especie>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Familia idFam = genero.getIdFam();
            if (idFam != null) {
                idFam = em.getReference(idFam.getClass(), idFam.getFamId());
                genero.setIdFam(idFam);
            }
            List<Especie> attachedEspecieList = new ArrayList<Especie>();
            for (Especie especieListEspecieToAttach : genero.getEspecieList()) {
                especieListEspecieToAttach = em.getReference(especieListEspecieToAttach.getClass(), especieListEspecieToAttach.getEspId());
                attachedEspecieList.add(especieListEspecieToAttach);
            }
            genero.setEspecieList(attachedEspecieList);
            em.persist(genero);
            if (idFam != null) {
                idFam.getGeneroList().add(genero);
                idFam = em.merge(idFam);
            }
            for (Especie especieListEspecie : genero.getEspecieList()) {
                Genero oldEspIdGenOfEspecieListEspecie = especieListEspecie.getEspIdGen();
                especieListEspecie.setEspIdGen(genero);
                especieListEspecie = em.merge(especieListEspecie);
                if (oldEspIdGenOfEspecieListEspecie != null) {
                    oldEspIdGenOfEspecieListEspecie.getEspecieList().remove(especieListEspecie);
                    oldEspIdGenOfEspecieListEspecie = em.merge(oldEspIdGenOfEspecieListEspecie);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Genero genero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Genero persistentGenero = em.find(Genero.class, genero.getGenId());
            Familia idFamOld = persistentGenero.getIdFam();
            Familia idFamNew = genero.getIdFam();
            List<Especie> especieListOld = persistentGenero.getEspecieList();
            List<Especie> especieListNew = genero.getEspecieList();
            if (idFamNew != null) {
                idFamNew = em.getReference(idFamNew.getClass(), idFamNew.getFamId());
                genero.setIdFam(idFamNew);
            }
            List<Especie> attachedEspecieListNew = new ArrayList<Especie>();
            for (Especie especieListNewEspecieToAttach : especieListNew) {
                especieListNewEspecieToAttach = em.getReference(especieListNewEspecieToAttach.getClass(), especieListNewEspecieToAttach.getEspId());
                attachedEspecieListNew.add(especieListNewEspecieToAttach);
            }
            especieListNew = attachedEspecieListNew;
            genero.setEspecieList(especieListNew);
            genero = em.merge(genero);
            if (idFamOld != null && !idFamOld.equals(idFamNew)) {
                idFamOld.getGeneroList().remove(genero);
                idFamOld = em.merge(idFamOld);
            }
            if (idFamNew != null && !idFamNew.equals(idFamOld)) {
                idFamNew.getGeneroList().add(genero);
                idFamNew = em.merge(idFamNew);
            }
            for (Especie especieListOldEspecie : especieListOld) {
                if (!especieListNew.contains(especieListOldEspecie)) {
                    especieListOldEspecie.setEspIdGen(null);
                    especieListOldEspecie = em.merge(especieListOldEspecie);
                }
            }
            for (Especie especieListNewEspecie : especieListNew) {
                if (!especieListOld.contains(especieListNewEspecie)) {
                    Genero oldEspIdGenOfEspecieListNewEspecie = especieListNewEspecie.getEspIdGen();
                    especieListNewEspecie.setEspIdGen(genero);
                    especieListNewEspecie = em.merge(especieListNewEspecie);
                    if (oldEspIdGenOfEspecieListNewEspecie != null && !oldEspIdGenOfEspecieListNewEspecie.equals(genero)) {
                        oldEspIdGenOfEspecieListNewEspecie.getEspecieList().remove(especieListNewEspecie);
                        oldEspIdGenOfEspecieListNewEspecie = em.merge(oldEspIdGenOfEspecieListNewEspecie);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = genero.getGenId();
                if (findGenero(id) == null) {
                    throw new NonexistentEntityException("The genero with id " + id + " no longer exists.");
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
            Genero genero;
            try {
                genero = em.getReference(Genero.class, id);
                genero.getGenId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The genero with id " + id + " no longer exists.", enfe);
            }
            Familia idFam = genero.getIdFam();
            if (idFam != null) {
                idFam.getGeneroList().remove(genero);
                idFam = em.merge(idFam);
            }
            List<Especie> especieList = genero.getEspecieList();
            for (Especie especieListEspecie : especieList) {
                especieListEspecie.setEspIdGen(null);
                especieListEspecie = em.merge(especieListEspecie);
            }
            em.remove(genero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Genero> findGeneroEntities() {
        return findGeneroEntities(true, -1, -1);
    }

    public List<Genero> findGeneroEntities(int maxResults, int firstResult) {
        return findGeneroEntities(false, maxResults, firstResult);
    }

    private List<Genero> findGeneroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Genero.class));
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

    public Genero findGenero(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Genero.class, id);
        } finally {
            em.close();
        }
    }

    public int getGeneroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Genero> rt = cq.from(Genero.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
