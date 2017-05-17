package it.htm.dto;

import java.util.List;

public class TaskDTO {

    int id;
    String description;
    float retribution;
    boolean execution;
    List<SkillDTO> skills;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRetribution() {
        return retribution;
    }

    public void setRetribution(float retribution) {
        this.retribution = retribution;
    }

    public boolean isExecution() {
        return execution;
    }

    public void setExecution(boolean execution) {
        this.execution = execution;
    }

    public List<SkillDTO> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillDTO> skills) {
        this.skills = skills;
    }
}
