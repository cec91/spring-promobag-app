package it.htm.dao;

import it.htm.dto.ProjectDTO;
import it.htm.entity.Architecture;
import it.htm.entity.Project;
import it.htm.entity.User;
import it.htm.entity.UserProject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    private EntityManager em = emf.createEntityManager();

    @Override
    public void saveProject(User owner, String name, String description, double budget) {
        Project prog = new Project();
        prog.setName(name);
        prog.setDescription(description);
        prog.setBudget(budget);
        prog.setState("ARCHITECTURE");
        em.getTransaction().begin();
        em.persist(prog);
        em.getTransaction().commit();

        em.getTransaction().begin();
        owner = em.merge(owner);
        em.getTransaction().commit();

        UserProject userProject = new UserProject();
        userProject.setProject(prog);
        userProject.setUser(owner);
        userProject.setRole("Owner");

        em.getTransaction().begin();
        em.persist(userProject);
        em.getTransaction().commit();
    }

    @Override
    public List<Project> getAllNewProjects() {
        return em.createQuery("SELECT p FROM Project p WHERE p.state =:projState").setParameter("projState", "ARCHITECTURE").getResultList();
    }

    @Override
    public List<Project> getAllSlicingProjects() {
        return em.createQuery("SELECT p FROM Project p WHERE p.state =:projState").setParameter("projState", "SLICING").getResultList();
    }

    @Override
    public List<Architecture> retrieveArchByProjectId(int projId) {
        Project p = (Project) em.createQuery("SELECT p FROM Project p WHERE p.id= :projId")
                .setParameter("projId", projId)
                .getSingleResult();

        return p.getArchitectures();
    }

    @Override
    public Project retrieveProjectById(int id) {
        Project p = (Project) em.createQuery("SELECT p FROM Project p WHERE p.id= :id").setParameter("id", id).getSingleResult();
        return p;
    }

    @Override
    public void updateProject(Project p) {
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }


}
