package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Betaalmiddel;
import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.BetaalmiddelService;
import be.thomasmore.travelmore.service.BoekingService;
import be.thomasmore.travelmore.service.PersoonService;
import be.thomasmore.travelmore.service.ReisService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class BoekingController implements Serializable {
    private Reis newReis = new Reis();
    private Boeking boeking = new Boeking();
    private List<Betaalmiddel> betaalmiddelen;

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
    }

    public String reisBoeken(int id){

        setReis(this.reisService.findReisById(id));
        setBetaalmiddelen(this.betaalmiddelService.findAllBetaalmiddelen());

        System.out.println(id);
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

    public String addBoeking(Date datum, boolean betaald, int betaalmiddelId, int gebruikersId, int reisId){

        System.out.println(datum);
        System.out.println(betaald);
        System.out.println(betaalmiddelId);
        System.out.println(gebruikersId);
        System.out.println(reisId);

        this.boeking.setReis(this.reisService.findReisById(reisId));
        this.boeking.setPersoon(this.persoonService.findPersoonById(gebruikersId));
        this.boeking.setDatum(datum);
        this.boeking.setBetaald(betaald);
        this.boeking.setBetaalmiddel(this.betaalmiddelService.findBetaalmiddelById(betaalmiddelId));

        this.boekingService.insert(boeking);

        return "index";
    }

}
