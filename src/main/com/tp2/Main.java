package com.tp2;

import com.tp2.model.Estudiante;
import com.tp2.repository.EstudianteRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Estudiante e1 = new Estudiante("Johnny", "Depp", 40, 'M', 27555000, "Tandil");
        Estudiante e2 = new Estudiante("Johnny", "TheWalrus", 8, 'M', 37000000, "Tandil");
        em.persist(e1);
        em.persist(e2);
        em.getTransaction().commit();

        EstudianteRepositoryImpl estudianteRepository = new EstudianteRepositoryImpl(em);
        System.out.println("[INFO] - " + estudianteRepository.getEstudiantes());

        em.close();
        emf.close();
    }
}
