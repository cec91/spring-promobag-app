package it.htm.dto;

import java.util.List;

public class ProjectDTO extends BasicDTO {

    public List<UserDTO> users;
    public String name;
    public String description;
    public String state;
    public double budget;
    private List<ArchitectureDTO> architectureDTO;

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<ArchitectureDTO> getArchitectureDTO() {
        return architectureDTO;
    }

    public void setArchitectureDTO(List<ArchitectureDTO> architectureDTO) {
        this.architectureDTO = architectureDTO;
    }
}