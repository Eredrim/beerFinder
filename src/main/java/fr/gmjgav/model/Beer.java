package fr.gmjgav.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Beer {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private String country;
    @ManyToMany(mappedBy = "beers")
    @JsonBackReference
    private Set<Bar> bars;

    public Beer() {
    }

    public Beer(String name, String type, String country) {
        this.name = name;
        this.type = type;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Bar> getBars() {
        return new ArrayList<>(bars);
    }

    public void setBars(List<Bar> bars) {
        this.bars = new HashSet<>(bars);
    }

    @Override
    public String toString() {
        return "Beer{" + "id=" + id + ", name=" + name + ", type=" + type + ", country=" + country + '}';
    }
}
