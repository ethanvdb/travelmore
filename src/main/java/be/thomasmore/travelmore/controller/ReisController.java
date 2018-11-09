package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Plaats;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.domain.Transportmiddel;
import be.thomasmore.travelmore.service.PlaatsService;
import be.thomasmore.travelmore.service.ReisService;
import be.thomasmore.travelmore.service.TransportmiddelService;
import com.sun.mail.imap.Rights;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class ReisController implements Serializable{
    private Reis newReis = new Reis();
    private List<Reis> reizen;
    private List<String> lijst = new ArrayList<String>();

    @EJB
    private ReisService reisService;
    @EJB
    private TransportmiddelService transportmiddelService;
    @EJB
    private PlaatsService plaatsService;

    public Reis getNewReis() {
        return newReis;
    }

    public void setNewReis(Reis newReis) {
        this.newReis = newReis;
    }

    public String getAllReizen(){
       setReizen(this.reisService.findAllReizen());
       return "zoekReizen";
    }

    public String getReizenByPlaats(String plaats){
        setReizen(this.reisService.findAllReizenByPlaats(plaats));
        return "zoekReizen";
    }

    public String getReizenByLand(String land){
        setReizen(this.reisService.findAllReizenByLand(land));
        return "zoekReizen";
    }

    public String filterReizen(long bestemmingId, long vertrekplaatsId, long transportmiddelId, int gekozenPrijs, int gekozenVrijePlaatsen){
        setReizen(this.reisService.filterReizen(bestemmingId, vertrekplaatsId, transportmiddelId, gekozenPrijs, gekozenVrijePlaatsen));
        return "zoekReizen";
    }

    public void submit(){
        this.reisService.insert(newReis);
    }

    public List<Reis> getReizen() {
        return reizen;
    }

    public void setReizen(List<Reis> reizen) {
        this.reizen = reizen;
    }

    public List<String> getLijst() {
        this.lijst.add("hallo");
        this.lijst.add("hallo");
        this.lijst.add("hallo");
        return this.lijst;
    }

    public void setLijst(List<String> lijst) {
        this.lijst = lijst;
    }

    public String vulReisTabel(){
        Transportmiddel bus = transportmiddelService.findTransportmiddelById(1);
        Transportmiddel vliegtuig = transportmiddelService.findTransportmiddelById(2);

        Plaats rome = plaatsService.findPlaatsById(1);
        Plaats berlijn = plaatsService.findPlaatsById(2);


        Reis reis1 = new Reis("Reis 1", new Date(), new Date(), 20, 300, bus, rome, berlijn);
        Reis reis2 = new Reis("Reis 1", new Date(), new Date(), 20, 350, vliegtuig, rome, berlijn);

        this.reisService.insert(reis1);
        this.reisService.insert(reis2);

        return "index";
    }

}