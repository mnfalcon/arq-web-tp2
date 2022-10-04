package com.tp2.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.tp2.dto.CarreraInscriptosDTO;
import com.tp2.dto.EstudianteCarreraDTO;

public class CarreraEstudianteRepositoryImpl implements CarreraEstudianteRepository{

	   private EntityManager em;
	   public CarreraEstudianteRepositoryImpl(EntityManager em) {
	        this.em = em;
	   }


	//recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
	@Override
	public List<EstudianteCarreraDTO> getEstudiantesByCarreraAndCiudad(Long idCarrera, String ciudad) {
		List<EstudianteCarreraDTO> estudiantes = this.em.createQuery(
				"SELECT new com.tp2.dto.EstudianteCarreraDTO(e.DNI, e.nombre, e.apellido, e.ciudad, c.nombre) "
						+ "FROM Estudiante e " + "JOIN CarreraEstudiante ce ON e.DNI = ce.id.estudianteId "
						+ "JOIN Carrera c ON c.id = ce.id.carreraId " + "WHERE c.id = ?1 AND e.ciudad = ?2",
				EstudianteCarreraDTO.class).setParameter(1, idCarrera).setParameter(2, ciudad).getResultList();

		return estudiantes;
	}

	//recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
	@Override
	public List<CarreraInscriptosDTO> getInscriptosSortedByCarrera(){
		TypedQuery<CarreraInscriptosDTO> q =  this.em.createQuery(
				"SELECT new com.tp2.dto.CarreraInscriptosDTO(ce.carrera.nombreCarrera, ce.carrera.id, COUNT(ce)) " +
						"FROM CarreraEstudiante ce JOIN Carrera c ON ce.carrera.id = c.id "
						+ "GROUP BY ce.id " +
						"ORDER BY COUNT(ce.carrera.id)",
				CarreraInscriptosDTO.class);

		return q.getResultList();
	}

	
	
}
