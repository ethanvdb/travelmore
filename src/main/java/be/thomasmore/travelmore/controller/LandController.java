package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Land;
import be.thomasmore.travelmore.service.LandService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class LandController {
    private Land newLand = new Land();

    @Inject
    private LandService landService;

    public String vulLandenTabel(){
        Land duitsland = new Land("Duitsland");
        this.landService.insert(duitsland);

        Land italie = new Land("Italië");
        this.landService.insert(italie);


        return "index";
    }

    public Land getNewLand() {
        return newLand;
    }

    public void setNewLand(Land newLand) {
        this.newLand = newLand;
    }

    public List<Land> getLanden(){
        return this.landService.findAllLanden();
    }

    public void submit(){
        this.landService.insert(newLand);
    }

}