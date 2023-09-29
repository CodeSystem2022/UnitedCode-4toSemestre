package UTN.Presentacion;

import UTN.Conexion.Conexion;
import UTN.datos.EstudianteDAO;
import UTN.dominio.Estudiante;
import com.sun.tools.jconsole.JConsoleContext;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SistemaEstudianteApp {
    public static void main(String[] args) {
        var salir = false; //recuerden esto ya lo hicimos antes
        var consola = new Scanner(System.in); //Para leer la informacion de la consol
        //Se crea una instancia de la clase servicio, esto lo hacemos fuera del ciclo
        var estudianteDao = new EstudianteDAO();//Esta instancia debe hacerce una vez
        while(!salir){
            try {
                mostrarMenu();
                //Este sera el metodo que devolvera un booleano ejecturopciones que devolvera un boolenao
                salir = ejecutarOpciones(consola, estudianteDao);//Este arroja una exception
            } catch(Exception e){
                System.out.println("Ocurrio un error al ejecutar la operacion: "+e.getMessage());
            }
        }//Fin del while
    }//Fin del main

    private static void mostrarMenu() {
        System.out.println("""
                *********** SISTEMA DE ESTUDIANTES ***********
                 1. Listar Estudiante
                 2. Buscar Estudiante
                 3. Agregar Estudiante
                 4. Modificar Estudiante
                 5. Eliminar Estudiante
                 6. Salir
                 
                 Elige una opcion:
                 """);
    }
//Metodo para ejecutar las opciones, va a regresar un valor booleano, ya que es el que
    //que puede modificar el valor de la variable salir, si es verdadero termina el ciclo while
    private  static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDAO) {

        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion) {
            case 1 -> { //Listar estudiantes
                System.out.println("Listado de Estudiantes...");
                //No muestra la informacion, solo recupera la info y regresa una lista
                var estudiantes = estudianteDAO.listarEstudiantes();//recibe el listado
                //Vamos a iterar cada objeto de tipo estudiante
                estudiantes.forEach(System.out::println);//para imprimir la lista
            }//Fin caso 1
            case 2 -> {//Buscar estudiante por ir
                System.out.println("Introduce el id_estudiante a buscar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
                if (encontrado)
                    System.out.println("Estudiante encontrado: " + estudiante);
                else
                    System.out.println("Estudiante NO encontrado: " + estudiante);
            }//Fin caso 2
            case 3 -> { //Agregar estudiante
                System.out.println("Agregar estudiante: ");
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("Telefono: ");
                var email = consola.nextLine();
                System.out.println("Email: ");
                //crear objeto estudiante(sin id)
                var estudiante = new Estudiante(nombre, apellido, telefono, email);
                var agregado = estudianteDAO.agregarEstudiante(estudiante);
                if (agregado)
                    System.out.println("Estudiante agregado: " + estudiante);
                else
                    System.out.println("Estudiante NO agregado: " + estudiante);
            }//Fin case 3
            case 4 -> {//Modificar estudiante
                System.out.println("Modificar estudiante: ");
                //Aqui lo primero es especificar cual es el id del estudiante a modificar
                System.out.println("Id del estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("Email: ");
                var email = consola.nextLine();
                //crea el objeto estudiante a modificar
                var estudiante = new Estudiante(idEstudiante, nombre, apellido, telefono, email);
                var modificado = estudianteDAO.modificarEstudiante(estudiante);
                if (modificado)
                    System.out.println("Estudiante modificado: " + estudiante);
                else
                    System.out.println("Estudiante No modificado: " + estudiante);
            }//Fin case 4
            case 5 -> {//Eliminar estudiante
                System.out.println("Eliminar estudiante: ");
                System.out.println("Id del estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminado = estudianteDAO.eliminarEstudiante(estudiante);
                if (eliminado)
                    System.out.println("El estudiante ha sido eliminado; " + estudiante);
                else
                    System.out.println("El estudiante NO ha sido eliminado: " + estudiante);
            }//Fin case 5
            case 6 -> { //Salir
                System.out.println("Hasta pronto!!! ");
                salir = true;
            }//Fin case 6
            default -> System.out.println("La opcion ingresada es incorrecta, vuelva a ingresar una opcion");
        }//fin del switch
        return salir;
    }
}//Fin de la clase
