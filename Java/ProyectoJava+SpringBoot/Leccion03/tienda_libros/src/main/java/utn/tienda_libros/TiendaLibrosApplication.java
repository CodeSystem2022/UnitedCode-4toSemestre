package utn.tienda_libros;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import utn.tienda_libros.vista.LibroFrom;

import java.awt.EventQueue;

@SpringBootApplication
public class TiendaLibrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaLibrosApplication.class, args);
	}
		ConfigurableBootstrapContext contextoSpring =
				new SpringApplicationBuilder(TiendaLibrosApplication.class)
						.headless(false)
						.web(WebApplicationType.NONE)
						.run(args);

		//Ejecutamos el código para cargar el formulario
		EventQueue.invokeLater(() -> {
			//Obtenemos el objeto from a traves del spring
		LibroFrom libroFrom = contextoSpring.getBean(LibroFrom.class);
		})

}
