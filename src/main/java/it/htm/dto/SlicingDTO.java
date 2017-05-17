package it.htm.dto;

import java.util.List;

public class SlicingDTO extends BasicDTO {

    public int id;
    public int user_id;
    public String description;
    public ComponentDTO component;
    public List<TaskDTO> tasks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ComponentDTO getComponent() {
        return component;
    }

    public void setComponent(ComponentDTO component) {
        this.component = component;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }
}
