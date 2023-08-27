package UTN.presentacion;

import UTN.conexion.Conexion;
import UTN.datos.EstudianteDAO;
import UTN.dominio.Estudiante;

import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {
       var salir = false; //recuerden esto ya lo hicimos antes
        var consola = new Scanner(System.in); //Para leer informacion de la consola
        //Se crea una instancia de la clase servicio, esto lo hacemos fuera del ciclo
        var estudianteDao = new EstudianteDAO(); //Esta instancia debe hacerse una vez
        while(!salir){
            try {
                mostrarMenu(); //Mostramos el menu
                //Este será el método ejecutarOpciones que devolverá un booleano
                salir = ejecutarOpciones(consola, estudianteDao); //Este arroja una excepción
            } catch(Exception e){
                System.out.println("Ocurrió un error al ejecutar la operación: "+e.getMessage());
            }
        }//Fin while
    }//Fin del main

    private static void mostrarMenu(){
	    System.out.print("""
            ******* Sistema de Estudiantes *******
            1. Listar Estudiantes
            2. Buscar Estudiantes
            3. Agregar Estudiante
            4. Modificar Estudiante
            5. Eliminar Estudiante
            6. Salir
            Elige una opcion:
            """);
    }

//Metodo para ejecutar las opciones, va a regresar un valor boolenao, ya que es el que
//puede modificar el valor de la variable salir, si es verdadero termina el ciclo while
    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDao){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
} //Fin de clase