package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Land;
import be.thomasmore.travelmore.repository.LandRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class LandService {
    @Inject
    private LandRepository landRepository;

    public Land findLandByNaam(String naam) {
        return landRepository.findByNaam(naam);
    }

    public Land findLandById(int id) {
        return landRepository.findById(id);
    }

    public List<Land> findAllLanden() {
        return landRepository.findAll();
    }

    public void updateNaam(int id, String newNaam) {
        Land reis = landRepository.findById(id);
        reis.setNaam(newNaam);
    }

    public void insert(Land land) {
        landRepository.insert(land);
    }
}
