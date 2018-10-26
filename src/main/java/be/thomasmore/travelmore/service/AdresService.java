package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Adres;
import be.thomasmore.travelmore.repository.AdresRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class AdresService {

    @Inject
    private AdresRepository adresRepository;

    public Adres findAdresById(int id) {
        return adresRepository.findById(id);
    }

    public List<Adres> findAllAdressen() {
        return adresRepository.findAll();
    }

    public void insert(Adres adres) {
        adresRepository.insert(adres);
    }
}
