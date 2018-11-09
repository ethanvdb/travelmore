package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "boeking")
@NamedQueries(
        {
                @NamedQuery(
                        name = Boeking.FIND_ALL,
                        query = "SELECT b FROM Boeking b"
                ),
                @NamedQuery(
                        name= Boeking.FIND_BY_ID,
                        query = "SELECT b from Boeking b"
                )
        }
)

public class Boeking {
    public static final String FIND_ALL = "Boeking.findAll";
    public static final String FIND_BY_ID = "Boeking.findById";

    @Id
    private int id;
    @Column(name = "naam")
    private String naam;
    @Column(name = "datum")
    private Date datum;
    @Column(name = "isBetaald")
    private boolean isBetaald;
    @OneToOne
    private Reis reis;
    @OneToOne
    private Persoon persoon;
    @OneToOne
    private Betaalmiddel betaalmiddel;

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

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public boolean isBetaald() {
        return isBetaald;
    }

    public void setBetaald(boolean betaald) {
        isBetaald = betaald;
    }

    public Reis getReis() {
        return reis;
    }

    public void setReis(Reis reis) {
        this.reis = reis;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public Betaalmiddel getBetaalmiddel() {
        return betaalmiddel;
    }

    public void setBetaalmiddel(Betaalmiddel betaalmiddel) {
        this.betaalmiddel = betaalmiddel;
    }
}
