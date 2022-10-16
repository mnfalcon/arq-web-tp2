package com.tp2.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.tp2.dto.CarreraInscriptosDTO;
import com.tp2.dto.CarreraReporteDTO;
import com.tp2.dto.EstudianteCarreraDTO;
import org.springframework.stereotype.Component;

@Component
public class CarreraEstudianteRepositoryImpl implements CarreraEstudianteRepository{

	   private EntityManager em;
	   public CarreraEstudianteRepositoryImpl(EntityManager em) {
	        this.em = em;
	   }


	//recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
	@Override
	public List<EstudianteCarreraDTO> getEstudiantesByCarreraAndCiudad(Long idCarrera, String ciudad) {
		List<EstudianteCarreraDTO> estudiantes = this.em.createQuery(
				"SELECT new com.tp2.dto.EstudianteCarreraDTO(e.dni, e.nombres, e.apellido, e.ciudadResidencia, c.nombreCarrera) "
						+ "FROM Estudiante e " + "JOIN CarreraEstudiante ce ON e.id = ce.estudiante.id "
						+ "JOIN Carrera c ON c.id = ce.carrera.id " + "WHERE c.id = ?1 AND e.ciudadResidencia = ?2",
						
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


	//Generar un reporte de las carreras, que para cada carrera incluya información de los
	//inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
	 //los años de manera cronológica
	//(c.nombreCarrera, ce.antiguedad, ce.egreso, e.nombres, e.apellido, e.dni, e.nroLibreta )
	@Override
	public List<CarreraReporteDTO> getCarreraReporte() {
		TypedQuery<CarreraReporteDTO> q = this.em.createQuery(
		"SELECT new com.tp2.dto.CarreraReporteDTO (c.nombreCarrera, ce.antiguedad, ce.egreso, e.dni, e.nroLibreta, e.nombres, e.apellido )" +
		"FROM Carrera c JOIN CarreraEstudiante ce ON c.id = ce.carrera.id JOIN Estudiante e ON ce.estudiante.id=e.id " +
		"ORDER BY c.nombreCarrera, ce.antiguedad", CarreraReporteDTO.class);
		return q.getResultList();
	}
	

	

	
	
}
