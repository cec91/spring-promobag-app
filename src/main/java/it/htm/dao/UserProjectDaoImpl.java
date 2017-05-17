package it.htm.dao;

import it.htm.entity.Project;
import it.htm.entity.User;
import it.htm.entity.UserProject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserProjectDaoImpl implements UserProjectDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    private EntityManager em = emf.createEntityManager();

    public String getRoleOfUser(Project project, User user) {
        return ((UserProject) em.createQuery("SELECT up FROM UserProject up WHERE up.project =:project and up.user =:user").setParameter("project", project).setParameter("user", user).getSingleResult()).getRole();
    }
}
