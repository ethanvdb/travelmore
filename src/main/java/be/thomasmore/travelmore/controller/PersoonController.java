package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Adres;
import be.thomasmore.travelmore.domain.Persoon;
import be.thomasmore.travelmore.domain.TypeGebruiker;
import be.thomasmore.travelmore.service.AdresService;
import be.thomasmore.travelmore.service.PersoonService;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import be.thomasmore.travelmore.service.TypeGebruikerService;
import be.thomasmore.travelmore.TrippleDes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.util.List;

@ManagedBean
@SessionScoped
public class PersoonController {

    private Persoon newPersoon = new Persoon();
    private Persoon login;
    private boolean bool = false;
    private HttpSession session;

//    //Klasse voor encryptie
//    private TrippleDes trippleDes;
//    {
//        try {
//            trippleDes = new TrippleDes();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

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
        return "index";
    }

    public Persoon getLogin() {
        return login;
    }

    public String loginPagina(){
        return "login";
    }

    public String accountPagina(){
        return "ingelogd";
    }

    public void setLogin(Persoon login) {
        if (login != null){
            this.login = login;
            System.out.println(this.login.getVoorNaam());
            this.bool = true;
        } else {
            System.out.println("KAPOT");
        }
    }

    public boolean getBoolean(){
        return this.bool;
    }

    public String getLoginNaam(){

        if (this.login != null){
            System.out.println(this.login.getVoorNaam());
            return this.login.getVoorNaam();
        }
        else {
            return "niet ingelogd";
        }
    }

//    public boolean isEmpty(Persoon login){
//        return login.getNaam() != null && login.getVoorNaam() != null && login.getEmail() != null && login.getWachtwoord() != null;
//    }f

    //Kijken of er een gebruiker bestaat met de opgegeven email
    public Persoon getPersoonByEmail(String email){
        Persoon persoon = this.persoonService.findPersoonByEmail(email);

        if (persoon != null){
            return persoon;
        }
        else {
            return null;
        }
    }

    //Kijken of er een gebruiker bestaat met de opgegeven mail en het juiste wachtwoord
    public String checkLogin(String email, String wachtwoord){
        Persoon persoon = getPersoonByEmail(email);
        if (persoon != null){
            //kijken of wachtwoord overeen komt
            if (persoon.getWachtwoord().equals(wachtwoord)){

                    System.out.println("PERSOON");
                    System.out.println(persoon.toString());
                     System.out.println("ENDPERSOON");
                setLogin(persoon);
                return "ingelogd";

            }
            else {
                return "login";
            }
        }
        else{
            //persoon bestaat niet
            return "registreren";
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

    public String logout(){
        this.login = null;
        return "login";
    }
}
