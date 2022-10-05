package com.tp2;

import com.tp2.model.Carrera;
import com.tp2.model.CarreraEstudiante;
import com.tp2.model.Estudiante;
import com.tp2.repository.CarreraEstudianteRepositoryImpl;
import com.tp2.repository.EstudianteRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Main {


    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

       log.info("******** Creacion de datos ********");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        log.info("******** Carga de Estudiantes (1a) ********");
        Estudiante e1 = new Estudiante("Johnny", "Depp", 40, 'M', 27555000, "Tandil",1);
        Estudiante e2 = new Estudiante("Johnny", "TheWalrus", 8, 'M', 37300000, "Tandil",2);
        Estudiante e3 = new Estudiante("Mad", "Max", 25, 'F', 37200000, "CABA",3);
        Estudiante e4 = new Estudiante("tom", "Doe", 18, 'F', 37100000, "Olavarria",4);
        Estudiante e5 = new Estudiante("Math", "Max", 20, 'F', 37123000, "BahiaBlanca",5);
        Estudiante e6 = new Estudiante("sack", "trump", 24, 'F', 37230000, "Azul",6);
        Estudiante e7 = new Estudiante("bob", "bob", 22, 'F', 37045670, "Azul",7);
        Estudiante e8 = new Estudiante("jack", "ripper", 44, 'F', 37578000, "CABA",8);
        Estudiante e9 = new Estudiante("lara", "sugar", 32, 'F', 3703400, "Tandil",9);
        Estudiante e10 = new Estudiante("sara", "smith", 27, 'F', 38965000, "Tandil",10);
        em.getTransaction().begin();
        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.persist(e4);
        em.persist(e5);
        em.persist(e6);
        em.persist(e7);
        em.persist(e8);
        em.persist(e9);
        em.persist(e10);
        em.getTransaction().commit();


        log.info("******** Carga de carreras ********");
        em.getTransaction().begin();
        Carrera c1 = new Carrera("Medicina");
        Carrera c2 = new Carrera("Ingenieria");
        Carrera c3 = new Carrera("Relaciones Internacionales");
        Carrera c4 = new Carrera("Abogacia");
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        em.getTransaction().commit();

        log.info("******** Inscripcion de Estudiantes a carreras (2b)********");
        em.getTransaction().begin();
        CarreraEstudiante ce1 = new CarreraEstudiante(e1, c1,2020,false);
        CarreraEstudiante ce2 = new CarreraEstudiante(e1, c2,2021,false);
        CarreraEstudiante ce3 = new CarreraEstudiante(e3, c2,2019,false);
        CarreraEstudiante ce4 = new CarreraEstudiante(e2, c3,2019,false);
        CarreraEstudiante ce5 = new CarreraEstudiante(e4, c3,2019,false);
        CarreraEstudiante ce6 = new CarreraEstudiante(e5, c2,2021,false);
        CarreraEstudiante ce7 = new CarreraEstudiante(e6, c4,2022,false);
        CarreraEstudiante ce8 = new CarreraEstudiante(e7, c4,2016,true);
        CarreraEstudiante ce9 = new CarreraEstudiante(e8, c1,2015,true);
        CarreraEstudiante ce10 = new CarreraEstudiante(e9, c1,2011,true);
        CarreraEstudiante ce11 = new CarreraEstudiante(e10, c2,2017,false);
        CarreraEstudiante ce12 = new CarreraEstudiante(e10, c4,2019,false);
        CarreraEstudiante ce13= new CarreraEstudiante(e5, c3,2021,false);
        CarreraEstudiante ce14= new CarreraEstudiante(e6, c1,2020,true);
        em.persist(ce1);
        em.persist(ce2);
        em.persist(ce3);
        em.persist(ce4);
        em.persist(ce5);
        em.persist(ce6);
        em.persist(ce7);
        em.persist(ce8);
        em.persist(ce9);
        em.persist(ce10);
        em.persist(ce11);
        em.persist(ce12);
        em.persist(ce13);
        em.persist(ce14);
        em.getTransaction().commit();


       log.info("******** SORTED BY CARRERA ********");

       EstudianteRepositoryImpl estudianteRepository = new EstudianteRepositoryImpl(em);

        log.info(estudianteRepository.getEstudiantes().toString());
        log.info("******** Estudiantes ordenados por nombre (2C) ********");
        log.info(estudianteRepository.getEstudiantesByName().toString());
        log.info("******** Estudiantes ordenados por nro libreta (2D) ********");
        log.info(estudianteRepository.getEstudianteByLibreta(5L).toString());
        log.info("******** Estudiantes ordenados por genero (2E) ********");
        log.info(estudianteRepository.getEstudiantesByGenero('F').toString());
        CarreraEstudianteRepositoryImpl carreraEstudianteRepository = new CarreraEstudianteRepositoryImpl(em);
        log.info("******** carreras ordenados por cantidad de inscriptos (2F) ********");
        log.info(carreraEstudianteRepository.getInscriptosSortedByCarrera().toString());
        log.info("******** carreras ordenados por cantidad de inscriptos (2g) ********");
        log.info(carreraEstudianteRepository.getEstudiantesByCarreraAndCiudad(1l,"CABA").toString());

        log.info("******** carreras ordenados por cantidad de inscriptos (3) ********");
        log.info(carreraEstudianteRepository.getCarreraReporte().toString());





     em.close();
        emf.close();
    }
}
