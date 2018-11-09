package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Reis;
import com.sun.corba.se.impl.naming.cosnaming.TransientNameServer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class ReisRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Reis findByNaam(String naam) {
        return entityManager.find(Reis.class, naam);
    }

    public Reis findById(int id) {
        return entityManager.find(Reis.class, id);
    }

    public List<Reis> findAll() {
        return entityManager.createNamedQuery(Reis.FIND_ALL, Reis.class).getResultList();
    }

    public List<Reis> findAllByPlaats(String plaats) {
        return entityManager.createNamedQuery(Reis.FIND_BY_PLAATS, Reis.class).setParameter("plaats", plaats).getResultList();
    }

    public List<Reis> findAllByLand(String land) {
        return entityManager.createNamedQuery(Reis.FIND_BY_LAND, Reis.class).setParameter("land", land).getResultList();
    }

    public List<Reis> filterReizen(int bestemmingId, int vertrekplaatsId, int transportmiddelId, int gekozenPrijs, int gekozenVrijePlaatsen){
        return entityManager.createNamedQuery(Reis.FIND_REIS_BY_FILTERS, Reis.class).setParameter("bestemmingid", bestemmingId)
                .setParameter("vertrekplaatsId", vertrekplaatsId).setParameter("transportmiddelId", transportmiddelId)
                .setParameter("gekozenVrijePlaatsen", gekozenVrijePlaatsen).setParameter("gekozenPrijs", gekozenPrijs).getResultList();
    }

    public void insert(Reis reis) {
        entityManager.persist(reis);
    }
}