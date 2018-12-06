package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "reis")
@NamedQueries(
        {
                @NamedQuery(
                        name = Reis.FIND_BY_PLAATS,
                        query = "SELECT r FROM Reis r WHERE r.bestemming.naam = :plaats"
                ),
                @NamedQuery(
                        name = Reis.FIND_BY_LAND,
                        query = "SELECT r FROM Reis r WHERE r.bestemming.land.naam = :land"
                ),
                @NamedQuery(
                        name = Reis.FIND_ALL,
                        query = "SELECT r FROM Reis r"
                ),
                @NamedQuery(
                        name= Reis.FIND_BY_ID,
                        query = "SELECT r from Reis r"
                ),
                @NamedQuery(
                        name= Reis.FIND_REIS_BY_FILTERS,
                        query = "SELECT r from Reis r where (r.bestemming.id = :bestemmingid or :bestemmingid is null or :bestemmingid = '') " +
                                " and (r.vertrekPlaats.id = :vertrekplaatsId or :vertrekplaatsId is null or :vertrekplaatsId = '')" +
                                " and (r.transportmiddel.id = :transportmiddelId or :transportmiddelId is null or :transportmiddelId = '')" +
                                " and (r.maxPlaatsen >= :gekozenVrijePlaatsen or :gekozenVrijePlaatsen is null or :gekozenVrijePlaatsen = '')" +
                                " and (r.prijs <= :gekozenPrijs or :gekozenPrijs is null or :gekozenPrijs = '')" +
                                " and (r.beginDatum >= :beginDatum or :beginDatum is null or :beginDatum = '')" +
                                " and (r.eindDatum <= :eindDatum or :eindDatum is null or :eindDatum = '')"
                )

        }
)

public class Reis {
    public static final String FIND_ALL = "Reis.findAll";
    public static final String FIND_BY_PLAATS = "Reis.findByPlaats";
    public static final String FIND_BY_LAND = "Reis.findByLand";
    public static final String FIND_BY_ID = "Reis.findById";
    public static final String FIND_REIS_BY_FILTERS = "Reis.findReisByFilters";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    public Reis(){

    }

    public Reis(String naam, Date beginDatum, Date eindDatum, int maxPlaatsen, int prijs, Transportmiddel transportmiddel, Plaats vertrekPlaats, Plaats bestemming) {
        this.naam = naam;
        this.beginDatum = beginDatum;
        this.eindDatum = eindDatum;
        this.maxPlaatsen = maxPlaatsen;
        this.prijs = prijs;
        this.transportmiddel = transportmiddel;
        this.vertrekPlaats = vertrekPlaats;
        this.bestemming = bestemming;
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