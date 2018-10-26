package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Betaalmiddel;
import be.thomasmore.travelmore.service.BetaalmiddelService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class BetaalmiddelController {
    private Betaalmiddel newBetaalmiddel = new Betaalmiddel();

    @Inject
    private BetaalmiddelService betaalmiddelService;

    public Betaalmiddel getNewBetaalmiddel() {
        return newBetaalmiddel;
    }

    public void setNewBetaalmiddel(Betaalmiddel newBetaalmiddel) {
        this.newBetaalmiddel = newBetaalmiddel;
    }

    public List<Betaalmiddel> getBetaalmiddelen(){
        return this.betaalmiddelService.findAllBetaalmiddelen();
    }

    public void submit(){
        this.betaalmiddelService.insert(newBetaalmiddel);
    }
}
