package it.htm;


import it.htm.dao.UserDaoImpl;
import it.htm.entity.Project;
import it.htm.entity.User;
import it.htm.entity.UserProject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Prova {

    public Prova() {}

    public void save() {
        System.out.println("prova");
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.insertUser("naike", "password");
    }
}
