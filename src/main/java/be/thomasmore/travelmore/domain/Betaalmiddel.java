package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "betaalmiddel")
@NamedQueries(
        {
                @NamedQuery(
                        name = Betaalmiddel.FIND_BY_ID,
                        query = "SELECT l FROM Betaalmiddel l WHERE l.id = :id"
                ),
                @NamedQuery(
                        name = Betaalmiddel.FIND_ALL,
                        query = "SELECT l FROM Betaalmiddel l"
                )
        }
)

public class Betaalmiddel {
    public static final String FIND_ALL = "Betaalmiddel.findAll";
    public static final String FIND_BY_ID = "Betaalmiddel.findById";

    @Id
    private int id;
    @Column(name = "soort")
    private String soort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }
}
