package com.tp2.repository;

import java.util.List;

import com.tp2.dto.CarreraInscriptosDTO;
import com.tp2.dto.CarreraReporteDTO;
import com.tp2.dto.EstudianteCarreraDTO;
import com.tp2.model.CarreraEstudiante;

public interface CarreraEstudianteRepository {
	
	public List<EstudianteCarreraDTO> getEstudiantesByCarreraAndCiudad(Long idCarrera, String ciudad);
	public List<CarreraInscriptosDTO> getInscriptosSortedByCarrera();
	public List<CarreraReporteDTO> getCarreraReporte();
}
