package it.htm.dto;

import it.htm.entity.User;
import java.util.List;

public class ArchitectureDTO extends BasicDTO {

    private List<ComponentDTO> components;

    private User user;

    public ArchitectureDTO(){}

    public List<ComponentDTO> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentDTO> components) {
        this.components = components;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
