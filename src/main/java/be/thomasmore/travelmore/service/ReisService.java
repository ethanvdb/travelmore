package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.repository.ReisRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ReisService {
    @Inject
    private ReisRepository reisRepository;

    public Reis findReisByNaam(String naam) {
        return reisRepository.findByNaam(naam);
    }

    public Reis findReisById(int id) {
        return reisRepository.findById(id);
    }

    public List<Reis> findAllReizen() {
        return reisRepository.findAll();
    }

    public List<Reis> findAllReizenByPlaats(String plaats){
        return reisRepository.findAllByPlaats(plaats);
    }

    public void updateNaam(int id, String newNaam) {
        Reis reis = reisRepository.findById(id);
        reis.setNaam(newNaam);
    }

    public void insert(Reis reis) {
        reisRepository.insert(reis);
    }
}
