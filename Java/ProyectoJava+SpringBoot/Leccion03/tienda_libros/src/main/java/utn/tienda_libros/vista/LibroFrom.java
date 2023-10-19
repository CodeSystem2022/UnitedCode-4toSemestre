package utn.tienda_libros.vista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utn.tienda_libros.servicio.LibroServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Component
public class LibroFrom extends JFrame {
    LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablalibros;
    private DefaultTableModel tablaModeloLibros;

    @Autowired
    public  LibroFrom(LibroServicio libroServicio){
        this.libroServicio = libroServicio;
        iniciarForma();
    }

    private void  iniciarForma(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,700);
        ///Para obtener les dimenciones de la ventana
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = toolkit.getScreenSize();
        int x = (tamanioPantalla.width - getWidth()/2);
        int y = (tamanioPantalla.height - getHeight()/2);
        setLocation(x, y);


    }

    private void createUIComponents() {
        this.tablaModeloLibros = new DefaultTableModel(0, 5);
        String[] cabecera = {"id", "Libro", "Autor", "Precio", "Existencias"};
        this.tablaModeloLibros.setColumnIdentifiers(cabecera);
        //Instanciar el objeto de JTable
        this.tablalibros = new JTable(tablaModeloLibros);
        listarLibros();


    }

    private void listarLibros(){
        //Limpiar la tabla
        tablaModeloLibros.setRowCount(0);
        //Obtener los libros de la Base de Datos
        var libros = libroServicio.listarLibros();
        //Iteramos cada libro
        libros.forEach(libro -> {//Funcion lambda
            //Creamos cada registro para agrearlos a la tabla
            Object [] renglonLibro = {
                    libro.getIdLibro(),
                    libro.getAutor(),
                    libro.getPrecio(),
                    libro.getExistencias(),
            };
        });

    }
}

