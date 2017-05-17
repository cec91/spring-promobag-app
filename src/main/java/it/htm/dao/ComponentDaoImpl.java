package it.htm.dao;

import it.htm.entity.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ComponentDaoImpl implements ComponentDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    private EntityManager em = emf.createEntityManager();

    @Override
    public List<Component> retrieveComponentByArchId(int id) {
        List<Component> c =  em.createQuery("SELECT c FROM Component c WHERE c.architecture.id =:id")
                .setParameter("id", id)
                .getResultList();
        return c;
    }
}