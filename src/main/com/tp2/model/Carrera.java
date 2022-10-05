package com.tp2.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data /* Esta anotacion genera getters, setters, etc */
@NoArgsConstructor
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCarrera;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "carrera_estudiante",
            joinColumns = @JoinColumn(name = "carrera_id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id"))
    private List<Estudiante> estudiantes;

    public Carrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
        this.estudiantes = new ArrayList<>();
    }

    public void addEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void removeEstudiante(Estudiante e) {
        estudiantes.remove(e);
    }
}
