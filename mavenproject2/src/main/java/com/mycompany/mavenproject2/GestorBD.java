/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author norri
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import models.Alumno;

public class GestorBD {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    static {
        emf = Persistence.createEntityManagerFactory("bd.odb");
        em = emf.createEntityManager();
    }

    public static void insertarAlumno(Alumno alumno) {
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
    }

    public static void listarTodo() {
        TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumno a", Alumno.class);
        List<Alumno> alumnos = query.getResultList();
        for (Alumno alumno : alumnos) {
            System.out.println("Alumno: " + alumno.getNombre());
            System.out.println("Nota AD: " + alumno.getNotaAD());
            System.out.println("Nota DI: " + alumno.getNotaDI());
            System.out.println("--------------------");
        }
    }

    public static void listarSuspensos() {
        TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumno a WHERE a.notaAD < 5 OR a.notaDI < 5", Alumno.class);
        List<Alumno> alumnos = query.getResultList();
        for (Alumno alumno : alumnos) {
            System.out.println("Alumno: " + alumno.getNombre());
            System.out.println("Nota AD: " + alumno.getNotaAD());
            System.out.println("Nota DI: " + alumno.getNotaDI());
            System.out.println("--------------------");
        }
    }

    public static void estadisticas() {
        TypedQuery<Double> notaADQuery = em.createQuery("SELECT AVG(a.notaAD) FROM Alumno a", Double.class);
        Double notaADMedia = notaADQuery.getSingleResult();
        System.out.println("Nota media en AD: " + notaADMedia);

        TypedQuery<Double> notaDIQuery = em.createQuery("SELECT AVG(a.notaDI) FROM Alumno a", Double.class);
        Double notaDIMedia = notaDIQuery.getSingleResult();
        System.out.println("Nota media en DI: " + notaDIMedia);

        TypedQuery<Long> aprobadosQuery = em.createQuery("SELECT COUNT(a) FROM Alumno a WHERE a.notaAD >= 5 AND a.notaDI >= 5", Long.class);
        Long aprobados = aprobadosQuery.getSingleResult();
        TypedQuery<Long> totalQuery = em.createQuery("SELECT COUNT(a) FROM Alumno a", Long.class);
        Long total = totalQuery.getSingleResult();
        Double ratioAprobados = ((double) aprobados) / total;
        System.out.println("Ratio de aprobados: " + ratioAprobados);
    }

    public static void cerrarConexion() {
        em.close();
        emf.close();
    }
}
