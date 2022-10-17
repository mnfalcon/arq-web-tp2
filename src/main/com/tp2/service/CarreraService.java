package com.tp2.service;

import com.tp2.model.Carrera;
import com.tp2.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CarreraService {
    @Autowired
    private CarreraRepository carreraRepository;

    public List<Carrera> getCarrerasByEstudiante(Long id) {
        return carreraRepository.getCarrerasByEstudiante(id);
    }

    public List<Carrera> getCarreras() {
        return carreraRepository.getCarreras();
    }
}
