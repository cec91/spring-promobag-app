package it.htm.dao;

import it.htm.entity.Project;
import it.htm.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


public class TaskDaoImpl implements TaskDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    private EntityManager em = emf.createEntityManager();
    @Override
    public List<Task> retrieveTaskBySlicingId(int id) {
        ArrayList<Task> t = (ArrayList<Task>) em.createQuery("SELECT t FROM Task t WHERE t.slicing.id = :id")
                .setParameter("id", id)
                .getResultList();

        return t;
    }

    @Override
    public List<Task> retrieveTasks() {
        ArrayList<Task> t = (ArrayList<Task>) em.createQuery("SELECT t FROM Task t").getResultList();

        return t;
    }

    @Override
    public Task getTaskById(int id) {
        Task t = (Task) em.createQuery("SELECT t FROM Task t WHERE t.id=: id").getSingleResult();
        return t;
    }

    @Override
    public void updateState(Task t) {
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
    }


}
