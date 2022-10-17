package com.tp2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp2.dto.CarreraInscriptosDTO;
import com.tp2.dto.CarreraReporteDTO;
import com.tp2.dto.EstudianteCarreraDTO;
import com.tp2.repository.CarreraEstudianteRepository;

@Service
public class CarreraEstudianteService {
	@Autowired
    private CarreraEstudianteRepository carreraEstudianteRepository;
	
	public List<EstudianteCarreraDTO> getEstudiantesByCarreraAndCiudad(Long idCarrera, String ciudad){
		return carreraEstudianteRepository.getEstudiantesByCarreraAndCiudad(idCarrera, ciudad);
	}
	
	public List<CarreraInscriptosDTO> getInscriptosSortedByCarrera(){
		return carreraEstudianteRepository.getInscriptosSortedByCarrera();
	}
	
	public List<CarreraReporteDTO> getCarreraReporte(){
		return carreraEstudianteRepository.getCarreraReporte();
	}

}
