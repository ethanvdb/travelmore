package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.TypeGebruiker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TypeGebruikerRepository {

    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public TypeGebruiker findById(int id) {
        return entityManager.find(TypeGebruiker.class, id);
    }

    public List<TypeGebruiker> findAll() {
        return entityManager.createNamedQuery(TypeGebruiker.FIND_ALL, TypeGebruiker.class).getResultList();
    }

    public void insert(TypeGebruiker typeGebruiker) {
        entityManager.persist(typeGebruiker);
    }
}
