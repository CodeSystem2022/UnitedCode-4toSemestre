package utn.estudiantes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.estudiantes.modelo.Estudiante;

import java.util.List;

@Service
public class EstudianteServicio implements IEstudianteServicio {
    @Autowired
    private EstudianteRepositorio estudianteRepositorio;
        
    @Override
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> estudiantes = estudiantesRepositorio.findAll();
        return estudiantes;
    }
    
    @Override
    public Estudiante buscarEstudiantePorId(Integer idEstudiante) {
        Estudiantes2022 estudiante = estudianteRepositorio.findById(idestudiantes2022).orElse(null);
        return estudiante;
    }
    
    @Override
    public void guardarEstudiante(Estudiante estudiante) {
        
    }
    
    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        
    }
}