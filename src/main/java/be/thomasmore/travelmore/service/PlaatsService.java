package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Plaats;
import be.thomasmore.travelmore.repository.PlaatsRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PlaatsService {
    @Inject
    private PlaatsRepository plaatsRepository;

    public Plaats findPlaatsByNaam(String naam) {
        return plaatsRepository.findByNaam(naam);
    }

    public Plaats findPlaatsById(int id) {
        return plaatsRepository.findById(id);
    }

    public List<Plaats> findAllPlaatsen() {
        return plaatsRepository.findAll();
    }

    public void updateNaam(int id, String newNaam) {
        Plaats plaats = plaatsRepository.findById(id);
        plaats.setNaam(newNaam);
    }

    public void insert(Plaats plaats) {
        plaatsRepository.insert(plaats);
    }
}
