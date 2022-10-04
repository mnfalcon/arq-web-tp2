package com.tp2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data /* Esta anotacion genera getters, setters, etc */
@NoArgsConstructor
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
    private int nroLibreta;

    public Estudiante(String nombres, String apellido, int edad, char genero, int dni, String ciudadResidencia, int nroLibreta) {
        this.nombres = nombres;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.dni = dni;
        this.ciudadResidencia = ciudadResidencia;
        this.nroLibreta = nroLibreta;
    }
    
}
