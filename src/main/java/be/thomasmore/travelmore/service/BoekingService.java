package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.repository.BoekingRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BoekingService {
    @Inject
    private BoekingRepository boekingRepository;

    public void insert(Boeking boeking) {
        boekingRepository.insert(boeking);
    }

    public List<Boeking> findAllByGebruikerId(int gebruikerId){
        return boekingRepository.findAllByGebruikerId(gebruikerId);
    }

    public List<Boeking> findAantalBoekingenByReisId(int reisId){
        return boekingRepository.findAantalBoekingenByReisId(reisId);
    }
}
