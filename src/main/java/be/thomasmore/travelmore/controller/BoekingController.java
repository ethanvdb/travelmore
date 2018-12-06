package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Betaalmiddel;
import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.domain.Persoon;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.BetaalmiddelService;
import be.thomasmore.travelmore.service.BoekingService;
import be.thomasmore.travelmore.service.PersoonService;
import be.thomasmore.travelmore.service.ReisService;
import be.thomasmore.travelmore.service.BevestigingService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

//mail sturen
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.mail.MessagingException;

@ManagedBean
@SessionScoped
public class BoekingController implements Serializable {
    private Reis newReis;
    private Boeking boeking = new Boeking();
    private List<Betaalmiddel> betaalmiddelen;
    private String statusMessage = "";
    private int reisId = 2;

    @EJB
    private ReisService reisService;
    @EJB
    private BetaalmiddelService betaalmiddelService;
    @EJB
    private BoekingService boekingService;
    @EJB
    private PersoonService persoonService;


    @PostConstruct
    public void init() {
        betaalmiddelen = this.betaalmiddelService.findAllBetaalmiddelen();
        newReis = reisService.findReisById(this.reisId);
    }

    public String reisBoeken(int id){

        setReis(this.reisService.findReisById(id));
        setBetaalmiddelen(this.betaalmiddelService.findAllBetaalmiddelen());
        setReisId(id);
        return "boekingForm";
    }

    public Reis getReis() {
        return newReis;
    }

    public void setReis(Reis newReis) {
        this.newReis = newReis;
    }

    public List<Betaalmiddel> getBetaalmiddelen() {
        return betaalmiddelen;
    }

    public void setBetaalmiddelen(List<Betaalmiddel> betaalmiddelen) {
        this.betaalmiddelen = betaalmiddelen;
    }

    public String addBoeking(boolean betaald, int betaalmiddelId, int gebruikersId, int reisId){
        Persoon gebruiker = persoonService.findPersoonById(gebruikersId);

        this.boeking.setReis(this.reisService.findReisById(reisId));
        this.boeking.setPersoon(gebruiker);
        this.boeking.setDatum(new Date());
        this.boeking.setBetaald(betaald);
        this.boeking.setBetaalmiddel(this.betaalmiddelService.findBetaalmiddelById(betaalmiddelId));

        this.boekingService.insert(boeking);

        try
        {
            BevestigingService.stuurBevestiging("dieter.verboven@gmail.com", "Bevesting reis bij Travelmore", "Beste "+ gebruiker.getVoorNaam() + " " + gebruiker.getNaam() + ", we hebben jouw boeking goed ontvangen.");

        }
        catch(MessagingException ex) {
            statusMessage = ex.getMessage();
        }
        return "index";
    }

    public int getReisId() {
        return reisId;
    }

    public void setReisId(int reisId) {
        this.reisId = reisId;
    }
}
