package utn.estudiantes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // Entity representa a una tabla de datos
//boilerplate - Repetitivo
@Data //Agrega los metodos get y set
@NoArgsConstructor //Construlle al constructor vacio
@AllArgsConstructor //Crea un constructor con todos los argumentos (id, nombre, apellido, telefono, etc)
@ToString

public class Estudiantes2022 {
    //Primero vamos a agregar atributos
    @Id //Este id es para que vaya agregando el orden del numero de la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idestudiantes2022;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}
