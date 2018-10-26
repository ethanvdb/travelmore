package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "reis")
@NamedQueries(
        {
                @NamedQuery(
                        name = Reis.FIND_BY_PLAATS,
                        query = "SELECT r FROM Reis r WHERE r.bestemming.naam = :naam"
                ),
                @NamedQuery(
                        name = Reis.FIND_ALL,
                        query = "SELECT r FROM Reis r"
                ),
                @NamedQuery(
                        name= Reis.FIND_BY_ID,
                        query = "SELECT r from Reis r"
                )
        }
)

public class Reis {
    public static final String FIND_ALL = "Reis.findAll";
    public static final String FIND_BY_PLAATS = "Reis.findByPlaats";
    public static final String FIND_BY_ID = "Reis.findById";

    @Id
    private int id;
    @Column(name = "naam")
    private String naam;
    @Column(name = "beginDatum")
    private Date beginDatum;
    @Column(name = "eindDatum")
    private Date eindDatum;
    @Column(name = "maxPlaatsen")
    private int maxPlaatsen;
    @Column(name="prijs")
    private int prijs;
    @OneToOne
    private Transportmiddel transportmiddel;
    @OneToOne
    private Plaats vertrekPlaats;
    @OneToOne
    private Plaats bestemming;



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

    public Date getBeginDatum() {
        return beginDatum;
    }

    public void setBeginDatum(Date beginDatum) {
        this.beginDatum = beginDatum;
    }

    public Date getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(Date eindDatum) {
        this.eindDatum = eindDatum;
    }

    public int getMaxPlaatsen() {
        return maxPlaatsen;
    }

    public void setMaxPlaatsen(int maxPlaatsen) {
        this.maxPlaatsen = maxPlaatsen;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    public Transportmiddel getTransportmiddel() {
        return transportmiddel;
    }

    public void setTransportmiddel(Transportmiddel transportmiddel) {
        this.transportmiddel = transportmiddel;
    }

    public Plaats getVertrekPlaats() {
        return vertrekPlaats;
    }

    public void setVertrekPlaats(Plaats vertrekPlaats) {
        this.vertrekPlaats = vertrekPlaats;
    }

    public Plaats getBestemming() {
        return bestemming;
    }

    public void setBestemming(Plaats bestemming) {
        this.bestemming = bestemming;
    }
}