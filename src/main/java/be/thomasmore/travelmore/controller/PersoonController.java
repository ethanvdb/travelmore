package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Adres;
import be.thomasmore.travelmore.domain.Persoon;
import be.thomasmore.travelmore.domain.TypeGebruiker;
import be.thomasmore.travelmore.service.AdresService;
import be.thomasmore.travelmore.service.PersoonService;
import be.thomasmore.travelmore.service.TypeGebruikerService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class PersoonController {

    private Persoon newPersoon = new Persoon();

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
        Persoon persoon2 = new Persoon("Goor", "Stef", "stefgoor@gmail.com", "admin", "+32140000001", "+32400000001", adresService.findAdresById(1), typeGebruikerService.findTypeGebruikerById(0));
        Persoon persoon3 = new Persoon("Van den Bleeken", "Ethan", "vandenbleekenethan@gmail.com", "admin", "+32140000001", "+32400000001", adresService.findAdresById(2), typeGebruikerService.findTypeGebruikerById(0));
        Persoon persoon4 = new Persoon("Verboven", "Dieter", "dieter.verboven@gmail.com", "admin", "+32140000001", "+32400000001", adresService.findAdresById(3), typeGebruikerService.findTypeGebruikerById(1));
        Persoon persoon5 = new Persoon("Verboven", "Dieter", "dieter.verboven@gmail.com", "admin", "+32140000001", "+32400000001", adresService.findAdresById(4), typeGebruikerService.findTypeGebruikerById(1));

        return "index";
    }
}
