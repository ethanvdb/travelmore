package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.ReisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class ReisController {
    private Reis newReis = new Reis();

    @Inject
    private ReisService reisService;

    public Reis getNewReis() {
        return newReis;
    }

    public void setNewReis(Reis newReis) {
        this.newReis = newReis;
    }

    public List<Reis> getReizen(){
        return this.reisService.findAllReizen();
    }

    public List<Reis> getReizenByLand(String land){
        return this.reisService.findAllReizenByLand(land);
    }

    public void submit(){
        this.reisService.insert(newReis);
    }

}