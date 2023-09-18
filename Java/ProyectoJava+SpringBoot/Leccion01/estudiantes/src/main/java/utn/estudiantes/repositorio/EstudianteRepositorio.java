package utn.estudiantes.repositorio;

import utn.estudiantes.modelo.Estudiantes2022;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EstudianteRepositorio extends JpaRepository<Estudiantes2022, Integer>{
}
