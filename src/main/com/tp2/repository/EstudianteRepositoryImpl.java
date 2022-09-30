package com.tp2.repository;

import com.tp2.model.Carrera;
import com.tp2.model.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EstudianteRepositoryImpl implements EstudianteRepository {
    private EntityManager em;

    public EstudianteRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Estudiante> getEstudiantes() {
        TypedQuery<Estudiante> q = em.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
        return q.getResultList();
    }

    @Override
    public Estudiante getEstudianteByLibreta() {
        return null;
    }

    @Override
    public List<Estudiante> getEstudiantesByGenero(char genero) {
        return null;
    }

    @Override
    public List<Estudiante> getEstudiantesByCarrerasXCiudad(Carrera carrera, String ciudad) {
        return null;
    }
}
