package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Persoon;
import be.thomasmore.travelmore.service.PersoonService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class PersoonController {

    private Persoon newPersoon = new Persoon();

    @Inject
    private PersoonService persoonService;

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



        return "index";
    }
}
