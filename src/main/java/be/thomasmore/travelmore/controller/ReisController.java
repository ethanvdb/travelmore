package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Plaats;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.domain.Transportmiddel;
import be.thomasmore.travelmore.service.PlaatsService;
import be.thomasmore.travelmore.service.ReisService;
import be.thomasmore.travelmore.service.TransportmiddelService;
import com.sun.mail.imap.Rights;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class ReisController implements Serializable{
    private Reis newReis = new Reis();
    private Reis currentReis;
    private List<Reis> reizen;
    private List<String> lijst = new ArrayList<String>();
    private int id = 21;

    @EJB
    private ReisService reisService;
    @EJB
    private TransportmiddelService transportmiddelService;
    @EJB
    private PlaatsService plaatsService;

    @PostConstruct
    public void init() {
        reizen = reisService.findAllReizen();
        currentReis = reisService.findReisById(this.id);
    }

    public Reis getNewReis() {
        return newReis;
    }

    public void setNewReis(Reis newReis) {
        this.newReis = newReis;
    }

    public String getAllReizen(){
       return "zoekReizen";
    }



    public String getReizenByPlaats(String plaats){
        if(plaats.isEmpty()){
            setReizen(this.reisService.findAllReizen());
        }else{
            setReizen(this.reisService.findAllReizenByPlaats(plaats));
        }
        return "zoekReizen";
    }

    public String getReizenByBestemmingId(int id){
        setReizen(this.reisService.findReizenByBestemmingId(id));
        return "zoekReizen";
    }

    public int getAantalReizenPerBestemming(int bestemmingId){
        return this.reisService.findReizenByBestemmingId(bestemmingId).size();
    }

    public String filterReizen(int bestemmingId, int vertrekplaatsId, int transportmiddelId, String gekozenPrijs, String gekozenVrijePlaatsen, Date beginDatum, Date eindDatum){
        int gekozenPrijsInt;
        int gekozenVrijePlaatsenInt;

        try{
            gekozenPrijsInt = Integer.parseInt(gekozenPrijs);
        }catch (NumberFormatException ex){
            gekozenPrijsInt = 2147483647;
        }

        try{
            gekozenVrijePlaatsenInt = Integer.parseInt(gekozenVrijePlaatsen);
        }catch (NumberFormatException ex){
            gekozenVrijePlaatsenInt = 1;
        }




        setReizen(this.reisService.filterReizen(bestemmingId, vertrekplaatsId, transportmiddelId, gekozenPrijsInt, gekozenVrijePlaatsenInt, beginDatum, eindDatum));
        return "zoekReizen";
    }

    public String nieuweReis(){
        setReizen(this.reisService.findAllReizen());
        return "nieuweReisForm";
    }

    public String addReis(String naam, int bestemmingId, int vertrekplaatsId, int transportmiddelId, String gekozenPrijs, String gekozenVrijePlaatsen, Date beginDatum, Date eindDatum){
        this.newReis.setNaam(naam);
        this.newReis.setBeginDatum(beginDatum);
        this.newReis.setEindDatum(eindDatum);
        this.newReis.setBestemming(plaatsService.findPlaatsById(bestemmingId));
        this.newReis.setVertrekPlaats(plaatsService.findPlaatsById(vertrekplaatsId));
        this.newReis.setTransportmiddel(transportmiddelService.findTransportmiddelById(transportmiddelId));
        this.newReis.setPrijs(Integer.parseInt(gekozenPrijs));
        this.newReis.setMaxPlaatsen(Integer.parseInt(gekozenVrijePlaatsen));

        this.submit();

        setReizen(this.reisService.findAllReizen());
        return "zoekReizen";
    }

    public String deleteReis(int reisId){
        Reis reis = this.reisService.findReisById(reisId);
        if(reis != null){
            this.reisService.delete(reis);
        }

        setReizen(this.reisService.findAllReizen());

        return "zoekReizen";
    }

    public String editReis(int reisId){
        setReizen(this.reisService.findAllReizen());
        setCurrentReis(this.reisService.findReisById(reisId));
        setId(reisId);
        return "editReisForm";
    }

    public String updateReis(int id){
        this.reisService.update(this.currentReis);
        setReizen(this.reisService.findAllReizen());
        return "zoekReizen";
    }

    public String reisDetails(int reisId){
        setCurrentReis(this.reisService.findReisById(reisId));

        return "reisDetails";
    }

    public void submit(){
        this.reisService.insert(newReis);
    }

    public List<Reis> getReizen() {
        return reizen;
    }

    public void setReizen(List<Reis> reizen) {
        this.reizen = reizen;
    }

    public void setLijst(List<String> lijst) {
        this.lijst = lijst;
    }

    public String vulReisTabel(){
        Transportmiddel bus = transportmiddelService.findTransportmiddelById(1);
        Transportmiddel vliegtuig = transportmiddelService.findTransportmiddelById(2);

        Plaats rome = plaatsService.findPlaatsById(1);
        Plaats berlijn = plaatsService.findPlaatsById(2);


        Reis reis1 = new Reis("Reis 1", new Date(), new Date(), 20, 300, bus, rome, berlijn);
        Reis reis2 = new Reis("Reis 2", new Date(), new Date(), 20, 350, vliegtuig, rome, berlijn);

        this.reisService.insert(reis1);
        this.reisService.insert(reis2);

        return "index";
    }

    public Reis getCurrentReis() {
        return currentReis;
    }

    public void setCurrentReis(Reis currentReis) {
        this.currentReis = currentReis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}