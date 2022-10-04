package com.tp2.dto;

public class EstudianteCarreraDTO {
	
	private int DNI;
	private String nombreEstudiante;
	private String apellido;
	private String ciudad;
	private String nombreCarrera;
	

	public EstudianteCarreraDTO(int DNI, String nombreEstudiante, String apellido, String ciudad,
								String nombreCarrera) {
		this.DNI = DNI;
		this.nombreEstudiante = nombreEstudiante;
		this.apellido = apellido;
		this.ciudad = ciudad;
		this.nombreCarrera = nombreCarrera;
	}

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public int getDNI() {
		return DNI;
	}

	@Override
	public String toString() {
		return "estudiantesCarreraDTO [DNI=" + DNI + ", nombreEstudiante=" + nombreEstudiante + ", apellido=" + apellido
				+ ", ciudad=" + ciudad + ", nombreCarrera=" + nombreCarrera + "]";
	}

	
	
    

}
