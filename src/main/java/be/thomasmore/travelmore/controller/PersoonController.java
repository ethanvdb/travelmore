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
    private TrippleDes trippleDes = new TrippleDes();

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
        }
        else{
            //persoon bestaat niet
            return null;
        }
    }
}
