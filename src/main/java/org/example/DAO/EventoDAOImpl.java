package org.example.DAO;

import jakarta.persistence.EntityManager;
import org.example.EntityManagerUtil;
import org.example.Evento;

import java.util.List;

public class EventoDAOImpl implements EventoDAO {

    @Override
    public void save(Evento evento) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            if (evento.getId() == null) {
                em.persist(evento);
            } else {
                em.merge(evento);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        finally {
            em.close();
        }

    }

    @Override
    public Evento findById(Long id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            Evento eventoTrovato = em.find(Evento.class, id);
            em.getTransaction().commit();
            return eventoTrovato;
        } catch (Exception e) {
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
            Evento eventoDaEliminare = em.find(Evento.class, id);
            if (eventoDaEliminare != null)
                em.remove(eventoDaEliminare);
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
    public List<Evento> findAll() {
        EntityManager em = EntityManagerUtil.getEntityManager();

        try{
            return em.createQuery("SELECT * FROM evento ", Evento.class).getResultList();
        }
        finally {
            em.close();
        }
    }

    public void close() {
    }
}
