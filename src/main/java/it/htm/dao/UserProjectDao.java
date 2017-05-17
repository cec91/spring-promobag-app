package it.htm.dao;


import it.htm.entity.Project;
import it.htm.entity.User;

public interface UserProjectDao {

    String getRoleOfUser(Project project, User user);
}
