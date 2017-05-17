package it.htm.dao;

import it.htm.entity.Component;
import it.htm.entity.Slicing;
import it.htm.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vincenzo on 27/11/16.
 */
public class SlicingDaoImpl implements SlicingDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    private EntityManager em = emf.createEntityManager();
    @Override
    public List<Slicing> retrieveSlicingByCompId(int component_id) {
        List<Slicing> t = (ArrayList<Slicing>) em.createQuery("SELECT s FROM Slicing s WHERE s.component.id = :component_id")
                .setParameter("component_id", component_id)
                .getResultList();
        return t;

    }

    @Override
    public Slicing retrieveSlicingById(int slicing_id) {
        return (Slicing) em.createQuery("SELECT s FROM Slicing s WHERE s.id =: slicing_id")
                .setParameter("slicing_id", slicing_id)
                .getSingleResult();

    }
}
