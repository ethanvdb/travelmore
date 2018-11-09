package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "typegebruiker")
@NamedQueries(
        {
                @NamedQuery(
                        name = TypeGebruiker.FIND_BY_ID,
                        query = "SELECT l FROM TypeGebruiker l WHERE l.id = :id"
                ),
                @NamedQuery(
                        name = TypeGebruiker.FIND_ALL,
                        query = "SELECT l FROM TypeGebruiker l"
                )
        }
)

public class TypeGebruiker {

    public static final String FIND_ALL = "TypeGebruiker.findAll";
    public static final String FIND_BY_ID = "TypeGebruiker.findByCode";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "typeNaam")
    private String typeNaam;

    public TypeGebruiker() {

    }

    public TypeGebruiker(String type)
    {
        this.setTypeNaam(type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeNaam() {
        return typeNaam;
    }

    public void setTypeNaam(String typeNaam) {
        this.typeNaam = typeNaam;
    }
}
