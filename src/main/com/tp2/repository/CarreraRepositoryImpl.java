package com.tp2.repository;

import com.tp2.model.Carrera;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class CarreraRepositoryImpl implements CarreraRepository {
    private EntityManager em;

    public CarreraRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Carrera> getCarrerasByEstudiante(long idEstudiante) {
        return null;
    }

    @Override
    public List<Carrera> getCarreras() {
        return null;
    }

    public Carrera saveCarrera(Carrera c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return c;
    }
}
