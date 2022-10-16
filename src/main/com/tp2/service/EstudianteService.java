package com.tp2.service;

import com.tp2.dto.EstudianteDTO;
import com.tp2.model.Estudiante;
import com.tp2.repository.EstudianteRepository;
import com.tp2.repository.EstudianteRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante saveEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = new Estudiante(estudianteDTO.getNombres(), estudianteDTO.getApellido(), estudianteDTO.getEdad(), estudianteDTO.getGenero(), estudianteDTO.getDni(), estudianteDTO.getCiudadResidencia(), estudianteDTO.getNroLibreta());
        return estudianteRepository.saveEstudiante(estudiante);
    }

    public List<Estudiante> getEstudiantes() {
        return estudianteRepository.getEstudiantes();
    }
}
