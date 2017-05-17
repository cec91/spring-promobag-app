package it.htm.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "task")
public class Task {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "task_id")
    private int taskId;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Slicing slicing;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Project project;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @Column(name = "description")
    private String description;

    @Column(name = "state")
    private boolean state;

    @Column(name = "retribution")
    private float retribution;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="task_skill", joinColumns=@JoinColumn(name="task_id"), inverseJoinColumns=@JoinColumn(name="skill_id"))
    private List<Skill> skills;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Slicing getSlicing() {
        return slicing;
    }

    public void setSlicing(Slicing slicing) {
        this.slicing = slicing;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public float getRetribution() {
        return retribution;
    }

    public void setRetribution(float retribution) {
        this.retribution = retribution;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
