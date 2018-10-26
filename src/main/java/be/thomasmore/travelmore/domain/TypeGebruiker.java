package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.Id;

public class TypeGebruiker {

    @Id
    private int id;
    @Column(name = "typeNaam")
    private String typeNaam;

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
