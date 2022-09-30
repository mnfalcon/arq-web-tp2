package com.tp2.repository;

import com.tp2.model.Carrera;
import com.tp2.model.Estudiante;

import java.util.List;

public interface EstudianteRepository {
    public List<Estudiante> getEstudiantes();
    public Estudiante getEstudianteByLibreta();
    public List<Estudiante> getEstudiantesByGenero(char genero);
    public List<Estudiante> getEstudiantesByCarrerasXCiudad(Carrera carrera, String ciudad);
}
