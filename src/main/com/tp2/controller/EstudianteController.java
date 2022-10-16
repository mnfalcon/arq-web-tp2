package com.tp2.controller;

import com.tp2.dto.EstudianteDTO;
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
    public Estudiante saveEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        return estudianteService.saveEstudiante(estudianteDTO);
    }
}
