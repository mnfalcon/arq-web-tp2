package com.tp2.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data /* Esta anotacion genera getters, setters, etc */
@NoArgsConstructor
@Table(name="carrera_estudiante")
public class CarreraEstudiante {
    static final int ANIOACTUAL = LocalDate.now().getYear();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int antiguedad;
    private boolean egreso;
    @ManyToOne
    private Estudiante estudiante;
    @ManyToOne
    private Carrera carrera;

    public CarreraEstudiante(Estudiante estudiante, Carrera carrera, int fechaIngreso, boolean egreso) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.antiguedad= ANIOACTUAL- fechaIngreso;
        this.egreso=egreso;
    }
}
