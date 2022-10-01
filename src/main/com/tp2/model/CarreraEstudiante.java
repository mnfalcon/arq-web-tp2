package com.tp2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data /* Esta anotacion genera getters, setters, etc */
@NoArgsConstructor
@Table(name="carrera_estudiante")
public class CarreraEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Estudiante estudiante;
    @ManyToOne
    private Carrera carrera;
    private int fechaIngreso;
    private int fechaEgreso;
}
