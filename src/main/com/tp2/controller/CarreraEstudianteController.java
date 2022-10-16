package com.tp2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp2.dto.CarreraInscriptosDTO;
import com.tp2.dto.CarreraReporteDTO;
import com.tp2.dto.EstudianteCarreraDTO;
import com.tp2.service.CarreraEstudianteService;

@RestController
@RequestMapping("/carreras")
public class CarreraEstudianteController {
	
	@Autowired
	private CarreraEstudianteService carreraEstudianteService ;
	

	@GetMapping("/orderByInscriptos")
	public List<CarreraInscriptosDTO>getInscriptosSortedByCarrera(){
		return carreraEstudianteService.getInscriptosSortedByCarrera();
	}
	
	@GetMapping("/inscriptosByCarreraAndCiudad/{id}/{ciudad}")
	public List<EstudianteCarreraDTO> getEstudiantesByCarreraAndCiudad(@PathVariable Long id, @PathVariable String ciudad){
		return carreraEstudianteService.getEstudiantesByCarreraAndCiudad(id, ciudad);
	}
	
	@GetMapping("/reporte")
	public List<CarreraReporteDTO> getCarreraReporte() {
		return carreraEstudianteService.getCarreraReporte();
	}
}
