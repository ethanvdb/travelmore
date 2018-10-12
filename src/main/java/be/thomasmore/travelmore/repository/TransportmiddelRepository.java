package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Transportmiddel;
import com.sun.corba.se.impl.naming.cosnaming.TransientNameServer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TransportmiddelRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Transportmiddel findById(int id) {
        return entityManager.find(Transportmiddel.class, id);
    }

    public List<Transportmiddel> findAll() {
        return entityManager.createNamedQuery(Transportmiddel.FIND_ALL, Transportmiddel.class).getResultList();
    }

    public void insert(Transportmiddel transportmiddel) {
        entityManager.persist(transportmiddel);
    }
}
