package fr.gmjgav.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Report {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @ManyToOne
    private Beer beer;
    @ManyToOne
    private Bar bar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public Report(Bar bar, Beer beer) {
        this.beer = beer;
        this.bar = bar;
    }
    
}
