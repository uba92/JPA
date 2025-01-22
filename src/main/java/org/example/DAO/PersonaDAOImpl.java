package org.example.DAO;

import jakarta.persistence.EntityManager;
import org.example.EntityManagerUtil;
import org.example.Persona;

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
}
