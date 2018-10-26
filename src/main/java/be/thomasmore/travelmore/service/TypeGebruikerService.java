package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.repository.TypeGebruikerRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TypeGebruikerService {

    @Inject
    private TypeGebruikerRepository typeGebruikerRepository;

    public TypeGebruiker findTypeGebruikerById(int id) {
        return typeGebruikerRepository.findById(id);
    }

    public List<TypeGebruiker> findAllTypeGebruikers() {
        return typeGebruikerRepository.findAll();
    }

    public void insert(TypeGebruiker typeGebruiker) {
        typeGebruikerRepository.insert(typeGebruiker);
    }
}
