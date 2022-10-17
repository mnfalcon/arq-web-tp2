package com.tp2.controller;
import java.util.List;


import com.tp2.model.Carrera;
import com.tp2.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/carrera")
public class CarreraController {

	@Autowired
    private CarreraService carreraService;

    @GetMapping
    public List<Carrera> getCarrerasByEstudiante(@RequestParam("estudianteId") Long id) {
        return carreraService.getCarrerasByEstudiante(id);
    }

    @GetMapping
    public List<Carrera> getCarreras() {
        return carreraService.getCarreras();
    }
}