package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Transportmiddel;
import be.thomasmore.travelmore.service.TransportmiddelService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class TransportmiddelController {
    private Transportmiddel newTransportmiddel = new Transportmiddel();

    @Inject
    private TransportmiddelService transportmiddelService;

    public Transportmiddel getNewTransportmiddel() {
        return newTransportmiddel;
    }

    public void setNewTransportmiddel(Transportmiddel newTransportmiddel) {
        this.newTransportmiddel = newTransportmiddel;
    }

    public List<Transportmiddel> getTransportmiddelen(){
        return this.transportmiddelService.findAllTransportmiddelen();
    }

    public void submit(){
        this.transportmiddelService.insert(newTransportmiddel);
    }

    public String vulTransportmiddelTabel(){
        Transportmiddel bus = new Transportmiddel("Bus");
        Transportmiddel vliegtuig = new Transportmiddel("Vliegtuig");

        transportmiddelService.insert(bus);
        transportmiddelService.insert(vliegtuig);

        return "index";
    }

}
