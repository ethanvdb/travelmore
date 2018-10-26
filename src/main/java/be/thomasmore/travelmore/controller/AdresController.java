package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Adres;
import be.thomasmore.travelmore.domain.Transportmiddel;
import be.thomasmore.travelmore.service.AdresService;
import be.thomasmore.travelmore.service.TransportmiddelService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class AdresController {

    private Adres newAdres = new Adres();

    @Inject
    private AdresService adresService;

    public Adres getNewAdres() {
        return newAdres;
    }

    public void setNewAdres(Adres newAdres) {
        this.newAdres = newAdres;
    }

    public List<Adres> getAdressen(){
        return this.adresService.findAllAdressen();
    }

    public void submit(){
        this.adresService.insert(newAdres);
    }

    public String vulAdresTabel()
    {
        Adres adres1 = new Adres("Geel", "Kleinhoefstraat", "2440", "4");
        adresService.insert(adres1);
        Adres adres2 = new Adres("Geel", "Kleinhoefstraat", "2440", "5");
        adresService.insert(adres2);
        Adres adres3 = new Adres("Geel", "Kleinhoefstraat", "2440", "6");
        adresService.insert(adres3);
        Adres adres4 = new Adres("Geel", "Kleinhoefstraat", "2440", "7");
        adresService.insert(adres4);
        Adres adres5 = new Adres("Geel", "Kleinhoefstraat", "2440", "8");
        adresService.insert(adres5);

        return "index";
    }
}
