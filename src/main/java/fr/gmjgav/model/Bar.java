package fr.gmjgav.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import se.walkercrou.places.Place;

@Entity
public class Bar {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String reference;
    @ManyToMany
    @JsonManagedReference
    private List<Beer> beers;

    public Bar(Long id, String name, String reference) {
        this.id = id;
        this.name = name;
        this.reference = reference;
    }

    public Bar(String name, String reference) {
        this.name = name;
        this.reference = reference;
    }

    public Bar() {
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<Beer> getBeers() {
        return beers;
    }

    public void setBeers(List<Beer> beers) {
        this.beers = beers;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.reference);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (obj instanceof Bar) {
            final Bar other = (Bar) obj;
            if (!Objects.equals(this.id, other.id)) {
                return false;
            }
        }
        else if (obj instanceof Place){
            final Place other = (Place) obj;
            if (!Objects.equals(this.reference, other.getPlaceId())) {
                return false;
            }
        }

        return true;
    }

}
