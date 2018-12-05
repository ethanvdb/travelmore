package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Adres;
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

    public void delete(int id){
        entityManager.createQuery("delete from Adres l where l.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public Adres findByPostCode(String postCode) {
        return entityManager.createNamedQuery(Adres.FIND_BY_POSTCODE, Adres.class).setParameter("postCode", postCode).getSingleResult();
    }

    public void insert(Adres adres) {
        entityManager.persist(adres);
    }
}
