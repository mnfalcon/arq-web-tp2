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
    public List<Estudiante> getEstudiantesByName() {
        TypedQuery<Estudiante> q = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.nombres", Estudiante.class);
        return q.getResultList();
    }


    @Override
    public Estudiante getEstudianteByLibreta(Long id) {
        TypedQuery<Estudiante> q = em.createQuery("SELECT e FROM Estudiante e WHERE e.id = :id", Estudiante.class);
        q.setParameter("id", id);
        return q.getSingleResult();
    }

    @Override
    public List<Estudiante> getEstudiantesByGenero(char genero) {
        TypedQuery<Estudiante> q = em.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :genero", Estudiante.class);
        q.setParameter("genero", genero);
        return q.getResultList();
    }

}
