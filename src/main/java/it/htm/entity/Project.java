package it.htm.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="project")
public class Project {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int projectId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "state")
    private String state;

    @Column(name = "budget")
    private double budget;


    @OneToMany(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private List<Architecture> architectures;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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

    public List<Architecture> getArchitectures() {
        return architectures;
    }

    public void setArchitectures(List<Architecture> architectures) {
        this.architectures = architectures;
    }
}
