package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Plaats;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.ReisService;
import com.sun.mail.imap.Rights;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class ReisController {
    private Reis newReis = new Reis();
    private List<Reis> reizen;

    @Inject
    private ReisService reisService;

    public Reis getNewReis() {
        return newReis;
    }

    public void setNewReis(Reis newReis) {
        this.newReis = newReis;
    }

    public List<Reis> getAllReizen(){
        return this.reisService.findAllReizen();
    }

    public String getReizenByPlaats(String plaats){
        this.reizen = this.reisService.findAllReizenByPlaats(plaats);
        return "zoekReizen";
    }

    public void submit(){
        this.reisService.insert(newReis);
    }

    public List<Reis> getReizen(){
        return this.reizen;
    }

}