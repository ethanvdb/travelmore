package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.service.TypeGebruikerService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class TypeGebruikerController {

    private TypeGebruiker newTypeGebruiker = new TypeGebruiker();

    @Inject
    private TypeGebruikerService typeGebruikerService;

    public TypeGebruiker getNewTypeGebruiker() {
        return newTypeGebruiker;
    }

    public void setNewTypeGebruiker(TypeGebruiker newTypeGebruiker) {
        this.newTypeGebruiker = newTypeGebruiker;
    }

    public List<TypeGebruiker> getTypeGebruikers(){
        return this.typeGebruikerService.findAllTypeGebruikers();
    }

    public void submit(){
        this.typeGebruikerService.insert(newTypeGebruiker);
    }

    public String vulTypeGebruikerTabel()
    {
        TypeGebruiker admin = new TypeGebruiker("Admin");
        typeGebruikerService.insert(admin);
        TypeGebruiker user = new TypeGebruiker("User");
        typeGebruikerService.insert(user);

        return "index";
    }
}
