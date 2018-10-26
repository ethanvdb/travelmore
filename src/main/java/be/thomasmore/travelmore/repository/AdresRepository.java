package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Adres;
import be.thomasmore.travelmore.domain.Transportmiddel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class AdresRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Adres findById(int id) {
        return entityManager.find(Adres.class, id);
    }

    public List<Adres> findAll() {
        return entityManager.createNamedQuery(Adres.FIND_ALL, Adres.class).getResultList();
    }

    public void insert(Adres adres) {
        entityManager.persist(adres);
    }
}
