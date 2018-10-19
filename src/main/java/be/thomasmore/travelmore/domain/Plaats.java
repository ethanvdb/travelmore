package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.Id;

public class Plaats {

    @Id
    private int id;
    @Column(name = "naam")
    private String naam;
    @Column(name = "land")
    private Land land;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }
}
