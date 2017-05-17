package it.htm.dao;

import it.htm.entity.Architecture;
import it.htm.entity.Project;
import it.htm.entity.User;

import java.util.List;

public interface ProjectDao {

    void saveProject(User owner, String name, String description, double budget);
    List<Project> getAllNewProjects();
    List<Project> getAllSlicingProjects();
    List<Architecture> retrieveArchByProjectId(int id);
    Project retrieveProjectById(int id);
    void updateProject(Project p);
}
