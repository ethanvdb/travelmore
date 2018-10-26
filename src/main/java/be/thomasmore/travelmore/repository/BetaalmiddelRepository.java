package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Betaalmiddel;
import com.sun.corba.se.impl.naming.cosnaming.TransientNameServer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BetaalmiddelRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Betaalmiddel findById(int id) {
        return entityManager.find(Betaalmiddel.class, id);
    }

    public List<Betaalmiddel> findAll() {
        return entityManager.createNamedQuery(Betaalmiddel.FIND_ALL, Betaalmiddel.class).getResultList();
    }

    public void insert(Betaalmiddel betaalmiddel) {
        entityManager.persist(betaalmiddel);
    }
}
