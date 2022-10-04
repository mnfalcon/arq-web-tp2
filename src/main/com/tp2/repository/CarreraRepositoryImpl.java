package com.tp2.repository;

import com.tp2.model.Carrera;

import javax.persistence.EntityManager;
import java.util.List;

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
}
