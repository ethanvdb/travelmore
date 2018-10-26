package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Betaalmiddel;
import be.thomasmore.travelmore.repository.BetaalmiddelRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BetaalmiddelService {
    @Inject
    private BetaalmiddelRepository betaalmiddelRepository;

    public Betaalmiddel findBetaalmiddelById(int id) {
        return betaalmiddelRepository.findById(id);
    }

    public List<Betaalmiddel> findAllBetaalmiddelen() {
        return betaalmiddelRepository.findAll();
    }

    public void updateSoort(int id, String newSoort) {
        Betaalmiddel betaalmiddel = betaalmiddelRepository.findById(id);
        betaalmiddel.setSoort(newSoort);
    }

    public void insert(Betaalmiddel betaalmiddel) {
        betaalmiddelRepository.insert(betaalmiddel);
    }
}
