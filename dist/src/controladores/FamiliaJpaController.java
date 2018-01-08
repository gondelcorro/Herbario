/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Genero;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Especie;
import modelo.Familia;

/**
 *
 * @author DelKo
 */
public class FamiliaJpaController implements Serializable {

    public FamiliaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Familia familia) {
        if (familia.getGeneroList() == null) {
            familia.setGeneroList(new ArrayList<Genero>());
        }
        if (familia.getEspecieList() == null) {
            familia.setEspecieList(new ArrayList<Especie>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Genero> attachedGeneroList = new ArrayList<Genero>();
            for (Genero generoListGeneroToAttach : familia.getGeneroList()) {
                generoListGeneroToAttach = em.getReference(generoListGeneroToAttach.getClass(), generoListGeneroToAttach.getGenId());
                attachedGeneroList.add(generoListGeneroToAttach);
            }
            familia.setGeneroList(attachedGeneroList);
            List<Especie> attachedEspecieList = new ArrayList<Especie>();
            for (Especie especieListEspecieToAttach : familia.getEspecieList()) {
                especieListEspecieToAttach = em.getReference(especieListEspecieToAttach.getClass(), especieListEspecieToAttach.getEspId());
                attachedEspecieList.add(especieListEspecieToAttach);
            }
            familia.setEspecieList(attachedEspecieList);
            em.persist(familia);
            for (Genero generoListGenero : familia.getGeneroList()) {
                Familia oldIdFamOfGeneroListGenero = generoListGenero.getIdFam();
                generoListGenero.setIdFam(familia);
                generoListGenero = em.merge(generoListGenero);
                if (oldIdFamOfGeneroListGenero != null) {
                    oldIdFamOfGeneroListGenero.getGeneroList().remove(generoListGenero);
                    oldIdFamOfGeneroListGenero = em.merge(oldIdFamOfGeneroListGenero);
                }
            }
            for (Especie especieListEspecie : familia.getEspecieList()) {
                Familia oldEspIdFamOfEspecieListEspecie = especieListEspecie.getEspIdFam();
                especieListEspecie.setEspIdFam(familia);
                especieListEspecie = em.merge(especieListEspecie);
                if (oldEspIdFamOfEspecieListEspecie != null) {
                    oldEspIdFamOfEspecieListEspecie.getEspecieList().remove(especieListEspecie);
                    oldEspIdFamOfEspecieListEspecie = em.merge(oldEspIdFamOfEspecieListEspecie);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Familia familia) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Familia persistentFamilia = em.find(Familia.class, familia.getFamId());
            List<Genero> generoListOld = persistentFamilia.getGeneroList();
            List<Genero> generoListNew = familia.getGeneroList();
            List<Especie> especieListOld = persistentFamilia.getEspecieList();
            List<Especie> especieListNew = familia.getEspecieList();
            List<String> illegalOrphanMessages = null;
            for (Genero generoListOldGenero : generoListOld) {
                if (!generoListNew.contains(generoListOldGenero)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Genero " + generoListOldGenero + " since its idFam field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Genero> attachedGeneroListNew = new ArrayList<Genero>();
            for (Genero generoListNewGeneroToAttach : generoListNew) {
                generoListNewGeneroToAttach = em.getReference(generoListNewGeneroToAttach.getClass(), generoListNewGeneroToAttach.getGenId());
                attachedGeneroListNew.add(generoListNewGeneroToAttach);
            }
            generoListNew = attachedGeneroListNew;
            familia.setGeneroList(generoListNew);
            List<Especie> attachedEspecieListNew = new ArrayList<Especie>();
            for (Especie especieListNewEspecieToAttach : especieListNew) {
                especieListNewEspecieToAttach = em.getReference(especieListNewEspecieToAttach.getClass(), especieListNewEspecieToAttach.getEspId());
                attachedEspecieListNew.add(especieListNewEspecieToAttach);
            }
            especieListNew = attachedEspecieListNew;
            familia.setEspecieList(especieListNew);
            familia = em.merge(familia);
            for (Genero generoListNewGenero : generoListNew) {
                if (!generoListOld.contains(generoListNewGenero)) {
                    Familia oldIdFamOfGeneroListNewGenero = generoListNewGenero.getIdFam();
                    generoListNewGenero.setIdFam(familia);
                    generoListNewGenero = em.merge(generoListNewGenero);
                    if (oldIdFamOfGeneroListNewGenero != null && !oldIdFamOfGeneroListNewGenero.equals(familia)) {
                        oldIdFamOfGeneroListNewGenero.getGeneroList().remove(generoListNewGenero);
                        oldIdFamOfGeneroListNewGenero = em.merge(oldIdFamOfGeneroListNewGenero);
                    }
                }
            }
            for (Especie especieListOldEspecie : especieListOld) {
                if (!especieListNew.contains(especieListOldEspecie)) {
                    especieListOldEspecie.setEspIdFam(null);
                    especieListOldEspecie = em.merge(especieListOldEspecie);
                }
            }
            for (Especie especieListNewEspecie : especieListNew) {
                if (!especieListOld.contains(especieListNewEspecie)) {
                    Familia oldEspIdFamOfEspecieListNewEspecie = especieListNewEspecie.getEspIdFam();
                    especieListNewEspecie.setEspIdFam(familia);
                    especieListNewEspecie = em.merge(especieListNewEspecie);
                    if (oldEspIdFamOfEspecieListNewEspecie != null && !oldEspIdFamOfEspecieListNewEspecie.equals(familia)) {
                        oldEspIdFamOfEspecieListNewEspecie.getEspecieList().remove(especieListNewEspecie);
                        oldEspIdFamOfEspecieListNewEspecie = em.merge(oldEspIdFamOfEspecieListNewEspecie);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = familia.getFamId();
                if (findFamilia(id) == null) {
                    throw new NonexistentEntityException("The familia with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws  NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Familia familia;
            try {
                familia = em.getReference(Familia.class, id);
                familia.getFamId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The familia with id " + id + " no longer exists.", enfe);
            }
        /*    List<String> illegalOrphanMessages = null;
            List<Genero> generoListOrphanCheck = familia.getGeneroList();
            for (Genero generoListOrphanCheckGenero : generoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Familia (" + familia + ") cannot be destroyed since the Genero " + generoListOrphanCheckGenero + " in its generoList field has a non-nullable idFam field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }*/
            List<Especie> especieList = familia.getEspecieList();
            for (Especie especieListEspecie : especieList) {
                especieListEspecie.setEspIdFam(null);
                especieListEspecie = em.merge(especieListEspecie);
            }
            em.remove(familia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Familia> findFamiliaEntities() {
        return findFamiliaEntities(true, -1, -1);
    }

    public List<Familia> findFamiliaEntities(int maxResults, int firstResult) {
        return findFamiliaEntities(false, maxResults, firstResult);
    }

    private List<Familia> findFamiliaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Familia.class));
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

    public Familia findFamilia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Familia.class, id);
        } finally {
            em.close();
        }
    }

    public int getFamiliaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Familia> rt = cq.from(Familia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
