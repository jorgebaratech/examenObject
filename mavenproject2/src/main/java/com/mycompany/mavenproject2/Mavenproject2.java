/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenproject2;

import models.Alumno;

/**
 *
 * @author norri
 */
public class Mavenproject2 {

  public static void main(String[] args) {

        Alumno alumno1 = new Alumno("Juan", "123456789", "juan@gmail.com", 8.0, 7.5);
        Alumno alumno2 = new Alumno("Pedro", "987654321", "pedro@gmail.com", 4.0, 6.5);
        Alumno alumno3 = new Alumno("María", "111111111", "maria@gmail.com", 6.0, 5.5);
        Alumno alumno4 = new Alumno("Sofía", "222222222", "sofia@gmail.com", 7.0, 4.5);
        Alumno alumno5 = new Alumno("Carlos", "333333333", "carlos@gmail.com", 9.0, 8.5);

        GestorBD.insertarAlumno(alumno1);
        GestorBD.insertarAlumno(alumno2);
        GestorBD.insertarAlumno(alumno3);
        GestorBD.insertarAlumno(alumno4);
        GestorBD.insertarAlumno(alumno5);

        GestorBD.listarTodo();
        GestorBD.listarSuspensos();
        GestorBD.estadisticas();

        GestorBD.cerrarConexion();
    }
}
