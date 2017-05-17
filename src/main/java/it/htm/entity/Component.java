package it.htm.entity;

import javax.persistence.*;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "component")
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int componentId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Architecture architecture;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "component_id")
    private List<Slicing> slicing;


    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
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

    public Architecture getArchitecture() {
        return architecture;
    }

    public void setArchitecture(Architecture architecture) {
        this.architecture = architecture;
    }

    public List<Slicing> getSlicing() {
        return slicing;
    }

    public void setSlicing(List<Slicing> slicing) {
        this.slicing = slicing;
    }
}
