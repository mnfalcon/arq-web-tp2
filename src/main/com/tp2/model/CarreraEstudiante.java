package com.tp2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data /* Esta anotacion genera getters, setters, etc */
@NoArgsConstructor
public class CarreraEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Estudiante estudiante;
    private int fechaIngreso;
    private int fechaEgreso;
}
