package it.htm.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "slicing")
public class Slicing {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int slicingId;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Component component;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "slicing_id")
    private List<Task> tasks;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @Column(name = "description")
    private String description;

    public int getSlicingId() {
        return slicingId;
    }

    public void setSlicingId(int slicingId) {
        this.slicingId = slicingId;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
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
}
