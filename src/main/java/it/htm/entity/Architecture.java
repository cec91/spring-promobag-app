package it.htm.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="architecture")
public class Architecture {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @Column(name="description")
    private String description;

    @OneToMany(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private List<Component> components;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
