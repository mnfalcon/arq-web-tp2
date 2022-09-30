package com.tp2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data /* Esta anotacion genera getters, setters, etc */
public class CarreraEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Estudiante estudiante;
    private int fechaIngreso;
    private int fechaEgreso;
}
