package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "transportmiddel")
@NamedQueries(
        {
                @NamedQuery(
                        name = Transportmiddel.FIND_BY_ID,
                        query = "SELECT l FROM Transportmiddel l WHERE l.id = :id"
                ),
                @NamedQuery(
                        name = Transportmiddel.FIND_ALL,
                        query = "SELECT l FROM Transportmiddel l"
                )
        }
)

public class Transportmiddel {
    public static final String FIND_ALL = "Transportmiddel.findAll";
    public static final String FIND_BY_ID = "Transportmiddel.findById";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "soort")
    private String soort;
    @Column(name = "bedrijf", nullable = true)
    private String bedrijf;

    public Transportmiddel(){

    }

    public Transportmiddel(String soort) {
        this.soort = soort;
    }

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

    public String getBedrijf() {
        return bedrijf;
    }

    public void setBedrijf(String bedrijf) {
        this.bedrijf = bedrijf;
    }

    @Override
    public String toString() {
        return this.soort;
    }
}
