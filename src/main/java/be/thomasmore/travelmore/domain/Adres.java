package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "adres")
@NamedQueries(
        {
                @NamedQuery(
                        name = Adres.FIND_BY_ID,
                        query = "SELECT l FROM Adres l WHERE l.id = :id"
                ),
                @NamedQuery(
                        name = Adres.FIND_ALL,
                        query = "SELECT l FROM Adres l"
                ),
                @NamedQuery(
                        name = Adres.FIND_BY_POSTCODE,
                        query = "SELECT l FROM Adres l WHERE l.postCode = :postCode"
                )
        }
)

public class Adres {

    public static final String FIND_ALL = "Adres.findAll";
    public static final String FIND_BY_ID = "Adres.findByCode";
    public static final String FIND_BY_POSTCODE = "Adres.findByPostCode";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "plaats")
    private String plaats;
    @Column(name = "straat")
    private String straat;
    @Column(name = "postCode")
    private String postCode;
    @Column(name = "nummer")
    private String nummer;

    public Adres() {

    }

    public Adres(String plaats, String straat, String postcode, String nummer)
    {
        this.setPlaats(plaats);
        this.setStraat(straat);
        this.setPostCode(postcode);
        this.setNummer(nummer);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }
}
