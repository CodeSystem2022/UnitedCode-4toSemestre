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
                mostrarMenu(); //Este será el método que devolverá un booleano
                salir = ejecutarOpciones(consola, estudianteDao); //Este arroja una excepción
            } catch(Exception e){
                System.out.println("Ocurrió un error al ejecutar la operación: "+e.getMessage());
            }
        }//Fin while
    }//Fin del main
} //Fin de clase