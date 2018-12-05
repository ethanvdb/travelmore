package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.repository.BoekingRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BoekingService {
    @Inject
    private BoekingRepository boekingRepository;

    public void insert(Boeking boeking) {
        boekingRepository.insert(boeking);
    }
}
