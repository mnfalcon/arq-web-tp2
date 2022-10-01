package com.tp2.repository;

import java.util.List;

import com.tp2.dto.carreraInscriptosDTO;
import com.tp2.dto.estudianteCarreraDTO;
import com.tp2.model.CarreraEstudiante;

public interface CarreraEstudianteRepository {
	
	public List<estudianteCarreraDTO> getEstudiantesByCarreraAndCiudad(int idCarrera, String ciudad);
	public List<carreraInscriptosDTO> getInscriptosByCarrera();
}
