package com.tp2.repository;

import java.util.List;


import javax.persistence.EntityManager;

import com.tp2.dto.carreraInscriptosDTO;
import com.tp2.dto.estudianteCarreraDTO;

public class CarreraEstudianteRepositoryImpl implements CarreraEstudianteRepository{

	   private EntityManager em;
	   public CarreraEstudianteRepositoryImpl(EntityManager em) {
	        this.em = em;
	   }


	//recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
	@Override
	public List<estudianteCarreraDTO> getEstudiantesByCarreraAndCiudad(int idCarrera, String ciudad) {
		List<estudianteCarreraDTO> estudiantes = this.em.createQuery(
				"SELECT new EstudianteCarreraDTO(e.DNI, e.nombre, e.apellido, e.ciudad, c.nombre) "
						+ "FROM Estudiante e " + "JOIN CarreraEstudiante ce ON e.DNI = ce.id.estudianteId "
						+ "JOIN Carrera c ON c.id = ce.id.carreraId " + "WHERE c.id = ?1 AND e.ciudad = ?2",
				estudianteCarreraDTO.class).setParameter(1, idCarrera).setParameter(2, ciudad).getResultList();

		return estudiantes;
	}

	//recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
	@Override
	public List<carreraInscriptosDTO> getInscriptosByCarrera(){
		List<carreraInscriptosDTO> carreras = this.em.createQuery(
				"SELECT new CarreraInscriptosDTO(c.nombre, COUNT(ce.id.estudianteId)) "
						+ "FROM CarreraEstudiante ce " + "JOIN Carrera c ON ce.id.carreraId = c.id "
						+ "GROUP BY ce.id.carreraId " + "ORDER BY COUNT(ce.id.estudianteId)",
				carreraInscriptosDTO.class).getResultList();

		return carreras;
	}

	
	
}
