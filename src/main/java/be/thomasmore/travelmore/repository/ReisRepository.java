package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Reis;
import com.sun.corba.se.impl.naming.cosnaming.TransientNameServer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Date;


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

    public List<Reis> findByBestemmingId(int bestemmingId){
        return entityManager.createNamedQuery(Reis.FIND_BY_BESTEMMINGID, Reis.class).setParameter("id", bestemmingId).getResultList();
    }

    public List<Reis> filterReizen(int bestemmingId, int vertrekplaatsId, int transportmiddelId, int gekozenPrijs, int gekozenVrijePlaatsen, Date beginDatum, Date eindDatum){
        return entityManager.createNamedQuery(Reis.FIND_REIS_BY_FILTERS, Reis.class).setParameter("bestemmingid", bestemmingId)
                .setParameter("vertrekplaatsId", vertrekplaatsId).setParameter("transportmiddelId", transportmiddelId)
                .setParameter("gekozenVrijePlaatsen", gekozenVrijePlaatsen).setParameter("gekozenPrijs", gekozenPrijs)
                .setParameter("beginDatum", beginDatum).setParameter("eindDatum", eindDatum).getResultList();
    }

    public void insert(Reis reis) {
        entityManager.persist(reis);
    }

    public void delete(Reis reis) {
        entityManager.remove(entityManager.contains(reis) ? reis : entityManager.merge(reis));
    }

    public void update(Reis reis){
        entityManager.merge(reis);
    }
}