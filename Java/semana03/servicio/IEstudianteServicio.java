package utn.estudiantes.servicio;

import utn.estudiantes.modelo.Estudiante;

import java.util.List;

public interface IEstudianteServicio {
    public List<Estudiante> listarEstudiantes();
    public Estudiante buscarEstudiantePorId(Integer idEtudiante);
    public void guardarEstudainte(Estudiante estudiante);
    public void eliminarEstudiante(Estudiante estudiante);

}
