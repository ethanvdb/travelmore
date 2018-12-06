package be.thomasmore.travelmore.domain;

import javax.inject.Named;
import javax.persistence.*;
import javax.persistence.GenerationType;
import be.thomasmore.travelmore.domain.Reis;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "plaats")
@NamedQueries(
        {
                @NamedQuery(
                        name = Plaats.FIND_ALL,
                        query = "SELECT p FROM Plaats p"
                ),
                @NamedQuery(
                        name= Plaats.FIND_BY_ID,
                        query = "SELECT p from Plaats p"
                ),
                @NamedQuery(
                        name= Plaats.FIND_ALL_BESTEMMINGEN,
                        query = "select p from Plaats p where p.id IN (SELECT r.bestemming.id from Reis r)"
                ),
                @NamedQuery(
                        name= Plaats.FIND_ALL_VERTREKPLAATSEN,
                        query = "select p from Plaats p where p.id IN (SELECT r.vertrekPlaats.id from Reis r)"
                )
        }
)
@NamedNativeQuery(
        name= Plaats.FIND_POPULAIRE_BESTEMMINGEN,
        query = "select p from Plaats p where p.id in (SELECT r.bestemming.id from Reis r)" +
                " group by p.id order by (SELECT count(b) from Boeking b where b.reis.id in " +
                "(select r.id from Reis r where r.bestemming.id = p.id)) desc limit 3"
)

public class Plaats {
    public static final String FIND_ALL = "Plaats.findAll";
    public static final String FIND_BY_ID = "Plaats.findById";
    public static final String FIND_ALL_BESTEMMINGEN = "Plaats.findAllBestemmingen";
    public static final String FIND_ALL_VERTREKPLAATSEN = "Plaats.findAllVertrekplaatsen";
    public static final String FIND_POPULAIRE_BESTEMMINGEN = "Plaats.findPopulaireBestemmingen";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "naam")
    private String naam;
    @OneToOne
    private Land land;

    public Plaats(){

    }

    public Plaats(String naam, Land land){
        this.land = land;
        this.naam = naam;
    }

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

    @Override
    public String toString() {
        return this.naam;
    }
}
