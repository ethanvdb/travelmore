package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Adres;
import be.thomasmore.travelmore.domain.Persoon;
import be.thomasmore.travelmore.domain.TypeGebruiker;
import be.thomasmore.travelmore.service.AdresService;
import be.thomasmore.travelmore.service.PersoonService;
import be.thomasmore.travelmore.service.TypeGebruikerService;
import be.thomasmore.travelmore.TrippleDes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.validation.constraints.Null;
import java.util.List;

@ManagedBean
@ViewScoped
public class PersoonController {

    private Persoon newPersoon = new Persoon();
    private Persoon login;
    private TrippleDes trippleDes;

    {
        try {
            trippleDes = new TrippleDes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Inject
    private PersoonService persoonService;
    @Inject
    private AdresService adresService;
    @Inject
    private TypeGebruikerService typeGebruikerService;

    public Persoon getNewPersoon() {
        return newPersoon;
    }

    public void setNewPersoon(Persoon newPersoon) {
        this.newPersoon = newPersoon;
    }

    public List<Persoon> getPersonen(){
        return this.persoonService.findAllPersonen();
    }

    public void submit(){
        this.persoonService.insert(newPersoon);
    }

    public String vulPersoonTabel() {

        Persoon persoon1 = new Persoon("Verboven", "Dieter", "verbovendieter@gmail.com", "admin", "+32140000001", "+32400000001", adresService.findAdresById(0), typeGebruikerService.findTypeGebruikerById(0));
        this.persoonService.insert(persoon1);
        Persoon persoon2 = new Persoon("Goor", "Stef", "stefgoor@gmail.com", "admin", "+32140000001", "+32400000001", adresService.findAdresById(1), typeGebruikerService.findTypeGebruikerById(0));
        this.persoonService.insert(persoon2);
        Persoon persoon3 = new Persoon("Van den Bleeken", "Ethan", "vandenbleekenethan@gmail.com", "admin", "+32140000001", "+32400000001", adresService.findAdresById(2), typeGebruikerService.findTypeGebruikerById(0));
        this.persoonService.insert(persoon3);
        Persoon persoon4 = new Persoon("Verboven", "Dieter", "dieter.verboven@gmail.com", "admin", "+32140000001", "+32400000001", adresService.findAdresById(3), typeGebruikerService.findTypeGebruikerById(1));
        this.persoonService.insert(persoon4);
        Persoon persoon5 = new Persoon("Verboven", "Dieter", "dieter.verboven@gmail.com", "admin", "+32140000001", "+32400000001", adresService.findAdresById(4), typeGebruikerService.findTypeGebruikerById(1));
        this.persoonService.insert(persoon5);

        return "index";
    }

    public Persoon getLogin() {
        return login;
    }

    public void setLogin(Persoon login) {
        this.login = login;
    }

    //Kijken of er een gebruiker bestaat met de opgegeven email
    public Persoon getPersoonByEmail(String email){
        Persoon persoon = this.persoonService.findPersoonByEmail(email);

        setLogin(null);

        if (persoon != null){
            return persoon;
        }
        else {
            return null;
        }
    }

    //Kijken of er een gebruiker bestaat met de opgegeven mail en het juiste wachtwoord
    public Persoon checkLogin(String email, String wachtwoord){
        Persoon persoon = getPersoonByEmail(email);
        if (persoon != null){
            //kijken of wachtwoord overeen komt
            if (trippleDes.decrypt(persoon.getWachtwoord()) == wachtwoord){
                setLogin(persoon);
                return persoon;
            }
            else {
                return null;
            }
        }
        else{
            //persoon bestaat niet
            return null;
        }
    }

    public String addPersoon(String voorNaam, String naam, String email, String password1, String password2){
        if (password1.equals(password2)){
            this.newPersoon.setVoorNaam(voorNaam);
            this.newPersoon.setNaam(naam);
            this.newPersoon.setEmail(email);
            this.newPersoon.setWachtwoord(password1);

            this.submit();

            return "login";
        }
        else {
            return "registreren";
        }
    }
}
