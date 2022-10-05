package com.tp2.dto;

import java.time.LocalDate;

public class CarreraReporteDTO {

	private String nombreCarrera;
	private int ingreso;
	private boolean graduacion;
	private int DNI;
	private int numLibreta;
	private String apellido;
	private String nombreEstudiante;
	
	public CarreraReporteDTO(String nombreCarrera, int ingreso, boolean graduacion, int dNI, int numLibreta,
			String apellido, String nombreEstudiante) {
		this.nombreCarrera = nombreCarrera;
		this.ingreso = ingreso;
		this.graduacion = graduacion;
		this.DNI = DNI;
		this.numLibreta = numLibreta;
		this.apellido = apellido;
		this.nombreEstudiante = nombreEstudiante;
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public int getIngreso() {
		return ingreso;
	}

	public void setIngreso(int ingreso) {
		this.ingreso = ingreso;
	}

	public boolean getGraduacion() {
		return graduacion;
	}

	public void setGraduacion(boolean graduacion) {
		this.graduacion = graduacion;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public int getDNI() {
		return DNI;
	}

	public int getNumLibreta() {
		return numLibreta;
	}

	@Override
	public String toString() {
		return "CarreraReporteDTO [nombreCarrera=" + nombreCarrera + ", ingreso=" + ingreso + ", graduacion="
				+ graduacion + ", DNI=" + DNI + ", numLibreta=" + numLibreta + ", apellido=" + apellido
				+ ", nombreEstudiante=" + nombreEstudiante + "]";
	}
	
	
	
}
