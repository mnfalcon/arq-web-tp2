package com.tp2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data /* Esta anotacion genera getters, setters, etc */
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCarrera;
    @OneToMany (fetch = FetchType.LAZY)
    private List<Estudiante> estudiantes;

}
