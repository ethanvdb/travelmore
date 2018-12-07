package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Boeking;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BoekingRepository {

    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Boeking findById(int id) {
        return entityManager.find(Boeking.class, id);
    }

    public List<Boeking> findAll() {
        return entityManager.createNamedQuery(Boeking.FIND_ALL, Boeking.class).getResultList();
    }

    public List<Boeking> findAllByGebruikerId(int gebruikerId){
        return entityManager.createNamedQuery(Boeking.FIND_BY_GEBRUIKERID, Boeking.class).setParameter("gebruikerId", gebruikerId).getResultList();
    }

    public List<Boeking> findAantalBoekingenByReisId(int reisId){
        return entityManager.createNamedQuery(Boeking.FIND_AANTALBOEKINGEN_BYREISID, Boeking.class).setParameter("reisId", reisId).getResultList();
    }

    public void insert(Boeking boeking) {
        entityManager.persist(boeking);
    }
}
