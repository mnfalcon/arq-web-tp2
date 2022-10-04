package com.tp2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CarreraInscriptosDTO {

	private String nombreCarrera;
	private long idCarrera;
	private long cantInscriptos;
	
	public CarreraInscriptosDTO(String nombreCarrera, Long idCarrera, long cantInscriptos) {
		this.nombreCarrera = nombreCarrera;
		this.idCarrera = idCarrera;
		this.cantInscriptos = cantInscriptos;
	}
	
	
	
}
