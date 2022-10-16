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

    @GetMapping ("/all")
    public List<Estudiante> getEstudiantes() {
        return estudianteService.getEstudiantes();
    }

    @PostMapping
    public Estudiante saveEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.saveEstudiante(estudiante);
    }
	
	@GetMapping("/allByName")
	public List<Estudiante> getEstudiantesByName() {
		return estudianteService.getEstudiantesByName();
	}
	
	@GetMapping("/allByGenero{genero}")
	public List<Estudiante> getEstudiantesByGenero(@PathVariable char genero) {
		return estudianteService.getEstudiantesByGenero(genero);
	}
	
	@GetMapping("/numeroLibreta{numeroLibreta}")
	public Estudiante getEstudianteByLibreta(@PathVariable Long numeroLibreta) {
		return estudianteService.getEstudianteByLibreta(numeroLibreta);
	}
}
