package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.Id;

public class Land {

    @Id
    private int id;
    @Column(name = "naam")
    private String naam;
    @Column(name = "vlagFoto")
    private String vlagFoto;

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

    public String getVlagFoto() {
        return vlagFoto;
    }

    public void setVlagFoto(String vlagFoto) {
        this.vlagFoto = vlagFoto;
    }
}
