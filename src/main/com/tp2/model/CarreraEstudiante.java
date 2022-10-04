package com.tp2.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Data /* Esta anotacion genera getters, setters, etc */
@NoArgsConstructor
//@Table(name="carrera_estudiante")
public class CarreraEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Estudiante estudiante;
    @ManyToOne
    private Carrera carrera;
    @Column(nullable = true)
    @ColumnDefault("-1")
    private int fechaIngreso;
    @Column(nullable = true)
    @ColumnDefault("-1")
    private int fechaEgreso;

    public CarreraEstudiante(Estudiante estudiante, Carrera carrera) {
        this.estudiante = estudiante;
        this.carrera = carrera;
    }
}
