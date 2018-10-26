package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "persoon")
@NamedQueries(
        {
                @NamedQuery(
                        name = Persoon.FIND_BY_ID,
                        query = "SELECT l FROM Persoon l WHERE l.id = :id"
                ),
                @NamedQuery(
                        name = Persoon.FIND_ALL,
                        query = "SELECT l FROM Persoon l"
                )
        }
)

public class Persoon {

    public static final String FIND_ALL = "Persoon.findAll";
    public static final String FIND_BY_ID = "Persoon.findByCode";

    @Id
    private int id;
    @Column(name = "naam")
    private String naam;
    @Column(name = "voorNaam")
    private String voorNaam;
    @Column(name = "email")
    private String email;
    @Column(name = "wachtwoord")
    private String wachtwoord;
    @Column(name = "telefoon")
    private String telefoon;
    @Column(name = "gsm")
    private String gsm;

    @OneToOne
    private Adres adres;
    @Column(name = "typeGebruiker")
    private TypeGebruiker typeGebruiker;

    public  Persoon() {

    }

    public Persoon(String naam, String voorNaam, String email, String wachtwoord, String telefoon, String gsm, Adres adres, TypeGebruiker typeGebruiker) {
        this.setNaam(naam);
        this.setVoorNaam(voorNaam);
        this.setEmail(email);
        this.setWachtwoord(wachtwoord);
        this.setTelefoon(telefoon);
        this.setGsm(gsm);
        this.setAdres(adres);
        this.setTypeGebruiker(typeGebruiker);
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

    public String getVoorNaam() {
        return voorNaam;
    }

    public void setVoorNaam(String voorNaam) {
        this.voorNaam = voorNaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public TypeGebruiker getTypeGebruiker() {
        return typeGebruiker;
    }

    public void setTypeGebruiker(TypeGebruiker typeGebruiker) {
        this.typeGebruiker = typeGebruiker;
    }
}
