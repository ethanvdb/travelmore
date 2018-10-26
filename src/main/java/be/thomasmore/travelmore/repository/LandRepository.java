package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Land;
import com.sun.corba.se.impl.naming.cosnaming.TransientNameServer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class LandRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Land findByNaam(String naam) {
        return entityManager.find(Land.class, naam);
    }

    public Land findById(int id) {
        return entityManager.find(Land.class, id);
    }

    public List<Land> findAll() {
        return entityManager.createNamedQuery(Land.FIND_ALL, Land.class).getResultList();
    }


    public void insert(Land land) {
        entityManager.persist(land);
    }
}