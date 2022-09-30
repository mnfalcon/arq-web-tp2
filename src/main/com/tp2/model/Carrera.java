package com.tp2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data /* Esta anotacion genera getters, setters, etc */
@NoArgsConstructor
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCarrera;
    @OneToMany (fetch = FetchType.LAZY)
    private List<Estudiante> estudiantes;

}
