package com.tp2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tp2.dto.CarreraInscriptosDTO;
import com.tp2.dto.CarreraReporteDTO;
import com.tp2.dto.EstudianteCarreraDTO;
import com.tp2.service.CarreraEstudianteService;

@RestController
@RequestMapping("/carreraEstudiante")
public class CarreraEstudianteController {
	
	@Autowired
	private CarreraEstudianteService carreraEstudianteService ;
	

	@GetMapping("/sortedByInscriptos")
	public List<CarreraInscriptosDTO>getInscriptosSortedByCarrera(){
		return carreraEstudianteService.getInscriptosSortedByCarrera();
	}
	
	@GetMapping
	public List<EstudianteCarreraDTO> getEstudiantesByCarreraAndCiudad(@RequestParam("carrera") Long id, @RequestParam("ciudad") String ciudad){
		return carreraEstudianteService.getEstudiantesByCarreraAndCiudad(id, ciudad);
	}
	
	@GetMapping("/reporte")
	public List<CarreraReporteDTO> getCarreraReporte() {
		return carreraEstudianteService.getCarreraReporte();
	}
}
