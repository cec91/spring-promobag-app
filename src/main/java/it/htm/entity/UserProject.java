package it.htm.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_project")
@IdClass(UserProjectPK.class)
public class UserProject {

    @ManyToOne(cascade = CascadeType.MERGE)
    @Id
    @PrimaryKeyJoinColumn
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @Id
    @PrimaryKeyJoinColumn
    private Project project;

    @Column(name = "role")
    private String role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
