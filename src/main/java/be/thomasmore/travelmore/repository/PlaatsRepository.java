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
        return entityManager.createNativeQuery("SELECT * FROM `plaats` WHERE plaats.id in (select bestemming_id from reis) group by id order by (select count(*) from boeking where reis_id in (SELECT id from reis where bestemming_id = plaats.id)) DESC limit 3", Plaats.class).getResultList();
    }

    public void insert(Plaats plaats) {
        entityManager.persist(plaats);
    }
}
