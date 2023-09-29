package utn.estudiantes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
//boilerplate - Repetitivo
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudiante;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

}
    String nl = System.lineSeparator();

    public static void main(String[] args) {
        logger.info("Iniciando la aplicación...");
        //Levantar la fabrica de Spring
        SpringApplicaction.run(EstudiantesApplication.class, args);
        logger.info("Aplicación Finalizada!");
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Ejecutando el   método run de Spring...");
    }
