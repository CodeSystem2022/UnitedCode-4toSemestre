package UTN.dominio;

public class Estudiante {
    private int idEstudiantes;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    public Estudiante(){} //Constructor vacio

    public Estudiante(int idEstudiantes) { //Constructor para la llave primaria idEstudiantes
        this.idEstudiantes = idEstudiantes;
    }

    public Estudiante(String nombre, String apellido, String telefono, String email) { //Este constr. nos sirve para insertar alumnos
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public Estudiante(int idEstudiantes,String nombre, String apellido, String telefono, String email){ //este constr nos va a servir para modificar
        this.idEstudiantes = idEstudiantes;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;

    }

    public int getIdEstudiantes() {
        return idEstudiantes;
    }

    public void setIdEstudiantes(int idEstudiantes) {
        this.idEstudiantes = idEstudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "idEstudiantes=" + idEstudiantes +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
