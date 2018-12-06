package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Plaats;
import com.sun.corba.se.impl.naming.cosnaming.TransientNameServer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class PlaatsRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Plaats findByNaam(String naam) {
        return entityManager.find(Plaats.class, naam);
    }

    public Plaats findById(int id) {
        return entityManager.find(Plaats.class, id);
    }

    public List<Plaats> findAll() {
        return entityManager.createNamedQuery(Plaats.FIND_ALL, Plaats.class).getResultList();
    }

    public List<Plaats> findAllBestemmingen(){
        return entityManager.createNamedQuery(Plaats.FIND_ALL_BESTEMMINGEN, Plaats.class).getResultList();
    }

    public List<Plaats> findAllVertrekplaatsen(){
        return entityManager.createNamedQuery(Plaats.FIND_ALL_VERTREKPLAATSEN, Plaats.class).getResultList();
    }

    public List<Plaats> findPopulaireBestemmingen(){
        return entityManager.createNativeQuery(Plaats.FIND_POPULAIRE_BESTEMMINGEN, Plaats.class).getResultList();
    }

    public void insert(Plaats plaats) {
        entityManager.persist(plaats);
    }
}
