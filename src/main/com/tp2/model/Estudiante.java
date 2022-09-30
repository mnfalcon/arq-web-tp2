package com.tp2.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data /* Esta anotacion genera getters, setters, etc */
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellido;
    private int edad;
    private char genero;
    private int dni;
    private String ciudadResidencia;
}
