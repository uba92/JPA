package org.example.DAO;

import jakarta.persistence.EntityManager;
import org.example.EntityManagerUtil;
import org.example.Persona;

import java.util.List;

public class PersonaDAOImpl implements PersonaDAO{
    @Override
    public void save(Persona persona) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }

    @Override
    public Persona findById(Long id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            Persona personaTrovata = em.find(Persona.class, id);
            em.getTransaction().commit();
            return personaTrovata;
        }
        catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally {
            em.close();
        }
    }

    @Override
    public void deleteById(Long id) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            Persona personaDaEliminare = em.find(Persona.class, id);
            if (personaDaEliminare != null)
                em.remove(personaDaEliminare);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            em.close();
        }
    }

    @Override
    public List<Persona> findAll() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try{
            return em.createQuery("SELECT * FROM persona ", Persona.class).getResultList();
        }
        finally {
            em.close();
        }
    }
}
