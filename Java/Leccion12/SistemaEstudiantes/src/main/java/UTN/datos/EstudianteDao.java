paquete UTN.datos;

importar UTN.dominio.Estudiante;

importar UTN.Conexion.Conexion.getConnection estático;
importar UTN.Conexion.Conexion.getConnection estático;
importar java.sql.Conexión;
importar java.sql.PreparedStatement;
importar java.sql.ResultSet;
importar java.sql.SQLException;
importar java.util.ArrayList;
importar java.util.List;

clase pública EstudianteDAO {

    //Metodo listar
    Lista pública<Estudiante> listarEstudiantes() {
        Lista<Estudiante> estudiantes = new ArrayList<>();
        //Creamos ahora algunos objetos que son necesarios para comunicarnos con la base de datos
        Declaración preparada ps; //se renombra como "ps" Statement es un objeto que nos va a ayudar a preparar la sentencia sql, que vamos a ejecutar hacia la base de datos
        Conjunto de resultados rs; //se renombra como "rs", es un objeto que nos permite almacenar el resultado obtenido desde la base de datos

        //Luego creamos un objeto de tipo de conexión
        Conexión con = getConnection();
        String sql = "SELECCIONAR * DE estudiantes2022 ORDENAR POR idestudiantes2022";
        intentar {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            mientras (rs.siguiente()) {
                var estudiante = new Estudiante();
                estudiante.setIdEstudiantes(rs.getInt("idestudiantes2022"));
                estudiante.setNombre(rs.getString("Nombre"));
                estudiante.setApellido(rs.getString("Apellido"));
                estudiante.setTelefono(rs.getString("correo electrónico"));
                //Falta agregarlo a la lista
                estudiantes.add(estudiante);
            }
        } captura (Excepción e) {
            System.out.println("Ocurrió un error al seleccionar datos " + e.getMessage());
        } finalmente {
            intentar {
                con.cerrar();
            } captura (Excepción e) {
                System.out.println("Ocurrió un error al cerrar la conexión: " + e.getMessage());
            }
        }//Fin del finalmente
        estudiantes de retorno;
    }//Fin del método

    //Método por id -> fin por id
    public boolean buscarEstudiantePorId(Estudiante estudiante) {
        Declaración preparada ps;
        Conjunto de resultados rs;
        Conexión con = getConnection();
        String sql = "SELECT * FROM estudiantes2022 DONDE idestudiantes2022=?";
        intentar {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiantes());
            rs = ps.executeQuery();
            si (rs.siguiente()) {
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setTelefono(rs.getString("correo electrónico"));
                devolver verdadero; // Se encontró un registro
            }//Fin si

        } captura (Excepción e) {
            System.out.println("Ocurrió un error al buscar estudiante: " + e.getMessage());

        }//Captura de aleta
        finalmente {
            intentar {
                con.cerrar();
            } captura (Excepción e) {
                System.out.println("Ocurrió un error al cerrar la conexión: " + e.getMessage());
            }//Captura de aleta
        }//Fin finalmente
        falso retorno;
    }

    //Método para agregar nuevo estudiante
    public boolean agregarEstudiante(Estudiante estudiante) {
        Declaración preparada ps;
        Conexión con = getConnection();
        String sql = "Insert INTO estudiantes2022 (nombre, apellido, teléfono, correo electrónico) VALORES (?, ?, ?, ?)";
        intentar {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.ejecutar();
            devolver verdadero;
        } captura (Excepción e) {
            System.out.println("Ocurrió un error al agregar estudiante: " + e.getMessage());

        }//Fin del catch
        finalmente {
            intentar {
                con.cerrar();
            } captura (Excepción e) {
                System.out.println("Erro al cerrar la conexión: " + e.getMessage());
            }//Captura de aleta
        }//Fin finalmente
        falso retorno;
    }//Fin del método agregarEstudiante

    //Método para modificar estudiante
    public boolean modificarEstudiante(Estudiante estudiante) {
        Declaración preparada ps;
        Conexión con = getConnection();
        String sql = "ACTUALIZAR estudiantes2022 SET nombre=?, apellido=?, telefono=?, email=? DONDE idestudiante2022=?";
        intentar {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiantes());
            ps.ejecutar();
            devolver verdadero;

        } captura (Excepción e) {
            System.out.printf("Error al modificar el estudiante " + e.getMessage());
        }//Captura de aleta
        finalmente {//luego de que se ponga el finalmente se debe abajo colocar un try{ con.close()
            intentar {
                con.cerrar();
            } captura (Excepción e) {
                System.out.printf("Error al cerrar la conexión: " + e.getMessage());
            }//Captura de aleta
        }//Fin finalmente
        falso retorno;
    }//Fin del método modificarEstudiante
        public boolean eliminarEstudiante(Estudiante estudiante){
            Declaración preparada ps;
            Conexión con = getConnection();
            String sql = "Eliminar DE estudiante2022 DONDE idestudiante2022=?";
            intentar {
                ps = con.prepareStatement(sql);
                ps.setInt(1, estudiante.getIdEstudiantes());
                ps.ejecutar();
                devolver verdadero;
            } captura (Excepción e) {
                System.out.printf("Error al tratar de eliminar al estudiante: " + e.getMessage());
            } finalmente {
                intentar {
                    con.cerrar();
                } captura (Excepción e){
                    System.out.println("Error al cerrar la conexión: "+e.getMessage());

                }
            }
            falso retorno;
    }
            //Luego se le debe agregar un main para lograr la ejecucion
            público estático vacío principal (String [] argumentos) {
                var estudianteDao = new EstudianteDAO();
                //var estudianteModificado = new Estudiante(1, "Juan Gabriel", "Juarez", "26045432345", "JuanGabr@gmail.com");
                //var modificado = estudianteDao.modificarEstudiante(estudianteModificado);
                //si(modificado)
                  // System.out.println("Estudiante modificado: "+estudianteModificado);
                //demás
                   // System.out.printf("El estudiante no se ha modificado: "+ estudianteModificado);

                //Agregar nuevo estudiante
                var nuevoEstudiante = new Estudiante("Carlos", "Lara","2604435676","carloslara@gmail.com");
                var agregado = estudianteDao.agregarEstudiante(nuevoEstudiante);
                si(agregado)
                   System.out.println("Estudiante agregado: "+nuevoEstudiante);
                demás
                   System.out.printf("No se ha agregado estudiante: "+nuevoEstudiante);

                //Listar los estudiantes

                System.out.println("Listado de estudiantes ");
                Lista<Estudiante> estudiantes = estudianteDao.listarEstudiantes();
                estudiantes.forEach(System.out::println); //Función lambda para imprimir)

                //Eliminar estudiante con id > en este caso será el id 3
                //var estudianteEliminar = new Estudiante(3);
                //var eliminado = estudianteDao.eliminarEstudiante((estudianteEliminar))
                //si (eliminado)
                    //System.out.printf("Estudiante eliminado: "+estudianteEliminar);
                //demás
                   // System.out.println("No se pudo eleminar el estudiante: "+estudianteEliminar);




