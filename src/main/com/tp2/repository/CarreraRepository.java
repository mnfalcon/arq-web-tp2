package com.tp2.repository;

import com.tp2.model.Carrera;

import java.util.List;

public interface CarreraRepository {

    public List<Carrera> getCarrerasByEstudiante(long idEstudiante);
    public List<Carrera> getCarreras();
}
