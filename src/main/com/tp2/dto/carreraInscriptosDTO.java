package com.tp2.dto;

public class carreraInscriptosDTO {

	private int idCarrera;
	private long cantInscriptos;
	
	public carreraInscriptosDTO(int idCarrera, long cantInscriptos) {
		this.idCarrera = idCarrera;
		this.cantInscriptos = cantInscriptos;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public long getCantInscriptos() {
		return cantInscriptos;
	}

	@Override
	public String toString() {
		return "cantidad inscriptos por carrera [idCarrera=" + idCarrera + ", cantInscriptos=" + cantInscriptos + "]";
	}
	
	
	
}
