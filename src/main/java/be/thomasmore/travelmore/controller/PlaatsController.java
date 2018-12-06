package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Plaats;
import be.thomasmore.travelmore.domain.Land;
import be.thomasmore.travelmore.service.PlaatsService;
import be.thomasmore.travelmore.service.LandService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class PlaatsController {
    private Plaats newPlaats = new Plaats();
    private List<Plaats> plaatsen;

    @Inject
    private PlaatsService plaatsService;
    @Inject
    private LandService landService;


    public Plaats getNewPlaats() {
        return newPlaats;
    }

    public void setNewPlaats(Plaats newPlaats) {
        this.newPlaats = newPlaats;
    }

    public List<Plaats> getPlaatsen(){
        return this.plaatsService.findAllPlaatsen();
    }

    public List<Plaats> getAllBestemmingen (){
        return this.plaatsService.findAllBestemmingen();
    }

    public List<Plaats> getAllVertrekplaatsen(){
        return this.plaatsService.findAllVertrekplaatsen();
    }

    public void submit(){
        this.plaatsService.insert(newPlaats);
    }

    public String vulPlaatsenTabel(){
        Land italie = this.landService.findLandById(2);
        Land duitsland = this.landService.findLandById(1);


        Plaats rome = new Plaats("Rome", italie);
        Plaats berlijn = new Plaats("Berlijn", duitsland);

        plaatsService.insert(rome);
        plaatsService.insert(berlijn);

        return "index";
    }

    public void setPlaatsen(List<Plaats> plaatsen) {
        this.plaatsen = plaatsen;
    }

    public List<Plaats> getPopulaireBestemmingen(){
        return this.plaatsService.findPopulaireBestemmingen();
    }

}