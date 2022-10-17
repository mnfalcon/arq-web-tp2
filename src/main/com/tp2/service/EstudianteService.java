package com.tp2.service;
import com.tp2.model.Estudiante;
import com.tp2.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante saveEstudiante(Estudiante estudiante) {
        Estudiante estudiante1 = new Estudiante(estudiante.getNombres(), estudiante.getApellido(), estudiante.getEdad(), estudiante.getGenero(), estudiante.getDni(), estudiante.getCiudadResidencia(), estudiante.getNroLibreta());
        return estudianteRepository.saveEstudiante(estudiante1);
    }

    public List<Estudiante> getEstudiantes() {
        return estudianteRepository.getEstudiantes();
    }

	public List<Estudiante> getEstudiantesByName() {
		return estudianteRepository.getEstudiantesByName();
	}

	public List<Estudiante> getEstudiantesByGenero(char genero) {
		return estudianteRepository.getEstudiantesByGenero(genero);
	}
	
	public Estudiante getEstudianteByLibreta(Long nroLibreta) {
		return estudianteRepository.getEstudianteByLibreta(nroLibreta);
	}


    
    
}
