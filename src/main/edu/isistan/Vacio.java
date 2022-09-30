package edu.isistan;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.isistan.dao.Direccion;
import edu.isistan.dao.Persona;
import edu.isistan.dao.Socio;
import edu.isistan.dao.Turno;

public class Vacio {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
