package be.thomasmore.travelmore.domain;

import javax.persistence.*;
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
                )
        }
)

public class Plaats {
    public static final String FIND_ALL = "Plaats.findAll";
    public static final String FIND_BY_ID = "Plaats.findById";

    @Id
    private int id;
    @Column(name = "naam")
    private String naam;
    @OneToOne
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
