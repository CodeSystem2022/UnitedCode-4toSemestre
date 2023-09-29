paquete UTN.Conexion;

importar java.sql.Conexión;
importar java.sql.DriverManager;
importar java.sql.SQLException;

Conexión de clase pública {
    //Metodo para poder conectarnos a la base de datos mysql
    Conexión estática pública getConnection() {
        Conexión conexión = nula;
        //Variables para conectarnos a la base de datos
        var baseDedatos = "estudiantes";
        var url = "jdbc:mysql://localhost:3306/" + baseDedatos;
        var usuario = "raíz";
        var contraseña = "admin";

        //Cargamos la clase driver de mysql en memoria
        intentar {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexión = DriverManager.getConnection(url, usuario, contraseña);
        } captura (ClassNotFoundException | SQLException e) {
            System.out.println("Ocurrió un error en la conexión: "+e.getMessage());
        }//Fin del catch
        conexión de regreso;
    } //Fin del método de conexión
}
