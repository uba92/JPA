package org.example.DAO;

import jakarta.persistence.EntityManager;
import org.example.EntityManagerUtil;
import org.example.Location;

import java.util.List;

public class LocationDAOImpl implements LocationDAO{

    @Override
    public void save(Location location) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(location);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            em.close();
        }
    }

    @Override
    public Location findById(Long id) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            Location locationDaTrovare = em.find(Location.class, id);
            em.getTransaction().commit();
            return locationDaTrovare;
        }
        catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            em.close();
        }
    }

    @Override
    public void deleteById(Long id) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            Location locationDaEliminare = em.find(Location.class, id);
            if(locationDaEliminare != null)
                em.remove(locationDaEliminare);
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
    public List<Location> findAll() {
        EntityManager em = EntityManagerUtil.getEntityManager();

        try{
            return em.createQuery("SELECT * FROM location", Location.class).getResultList();
        }
        finally {
            em.close();
        }
    }
}
