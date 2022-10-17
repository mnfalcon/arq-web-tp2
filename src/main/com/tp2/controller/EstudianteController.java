package com.tp2.controller;

import com.tp2.model.Estudiante;
import com.tp2.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> getEstudiantes() {
        return estudianteService.getEstudiantes();
    }

    @PostMapping
    public Estudiante saveEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.saveEstudiante(estudiante);
    }
	
	@GetMapping("/sortedByName")
	public List<Estudiante> getEstudiantesByName() {
		return estudianteService.getEstudiantesByName();
	}
	
	@GetMapping
	public List<Estudiante> getEstudiantesByGenero(@RequestParam("genero") char genero) {
		return estudianteService.getEstudiantesByGenero(genero);
	}
	
	@GetMapping
	public Estudiante getEstudianteByLibreta(@RequestParam("numeroLibreta") Long numeroLibreta) {
		return estudianteService.getEstudianteByLibreta(numeroLibreta);
	}
}
