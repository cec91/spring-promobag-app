package it.htm.dao;


import it.htm.entity.Project;
import it.htm.entity.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserDao {

    User getUserByName(String name);
    void insertUser();
    User getUserById(int id);
    List<User> getUsersByProject(Project project);
}
