package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Plaats;
import be.thomasmore.travelmore.service.PlaatsService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class PlaatsController {
    private Plaats newPlaats = new Plaats();

    @Inject
    private PlaatsService plaatsService;

    public Plaats getNewPlaats() {
        return newPlaats;
    }

    public void setNewPlaats(Plaats newPlaats) {
        this.newPlaats = newPlaats;
    }

    public List<Plaats> getPlaatsen(){
        return this.plaatsService.findAllPlaatsen();
    }



    public void submit(){
        this.plaatsService.insert(newPlaats);
    }

}