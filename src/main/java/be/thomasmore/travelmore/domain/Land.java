package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "land")
@NamedQueries(
        {
                @NamedQuery(
                        name = Land.FIND_BY_NAAM,
                        query = "SELECT l FROM Land l WHERE l.naam = :naam"
                ),
                @NamedQuery(
                        name = Land.FIND_ALL,
                        query = "SELECT l FROM Land l"
                ),
                @NamedQuery(
                        name= Land.FIND_BY_ID,
                        query = "SELECT l from Land l"
                )
        }
)

public class Land {
    public static final String FIND_ALL = "Land.findAll";
    public static final String FIND_BY_ID = "Land.findById";
    public static final String FIND_BY_NAAM = "Land.findByNaam";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "naam")
    private String naam;

    public Land(){
    }

    public Land(String naam) {
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

}