package it.htm.entity;

import javax.persistence.*;

@Entity
@Table(name="skill")
public class Skill {

    public Skill() {

    }

    public Skill(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "skill_id")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
