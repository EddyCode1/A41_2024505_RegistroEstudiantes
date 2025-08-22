package org.jrae.registroEstudiante;

import org.jrae.registroEstudiante.dominio.service.IEstudianteService;
import org.jrae.registroEstudiante.persistence.entity.Estudiante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class RegistroEstudianteApplication {

		@Autowired
		private IEstudianteService estudianteService;
		// crear nuestro objeto (herramienta) logger para interactuar con la consola
		private static final Logger logger = LoggerFactory.getLogger(RegistroEstudianteApplication.class);
		// crea un objeto String para saltos de linea
		String sl = System.lineSeparator();

		public static void main(String[] args) {
			logger.info("Aqui inicia nuestra aplicación");
		SpringApplication.run(RegistroEstudianteApplication.class, args);
			logger.info("Aqui termino la aplicacion");
		}

	// @Override
	public void run(String... args) throws Exception {
		RegistroEstudiante();
	}

	private void RegistroEstudiante(){
		logger.info("******Aplicacion de Registro de Estudiantes*******");
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir){
			var opcion = mostrarMenu(consola);
			salir = ejecutarOpciones(consola, opcion);
			logger.info(sl);
		}
	}

	private int mostrarMenu(Scanner consola){
		logger.info("""
				\n *****Aplicacion****
				1. Listar Todos los Estudiantes
				2. Buscar Cliente por codigo
				3. Agregar Nuevo Cliente
				4. Mostrara Cliente
				5. Eliminar Cliente
				6. salir
				ejecutar una opcion: \s""");
		var opcion = Integer.parseInt(consola.nextLine());
		return opcion;
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion){
		var salir = false;
		switch (opcion) {
			case 1 -> {
				logger.info(sl+"***Listado de todos los clientes***"+sl);
				List<Estudiante> estudiantes = estudianteService.listarEstudiantes();
				estudiantes.forEach(estudiante -> logger.info(estudiante.toString()+sl));
			}
			case 2 -> {
				logger.info(sl+"Buscar Cliente por su codigo ***"+sl);
				var codigo = Integer.parseInt(consola.nextLine());
				Estudiante estudiante = estudianteService.buscarEstudiantePorId(codigo);
				if (estudiante != null){
					logger.info("Estudiante encontrado "+sl+ estudiante + sl);
				} else {
					logger.info("Estudiante no encontrado"+sl + estudiante + sl );
				}
			}
			case 3 -> {
				logger.info(sl+"*** Agregar nuevo Cliente ****" +sl);
				logger.info("Ingrese su nombre: ");
				var nombre = consola.nextLine();
				logger.info("Ingrese su apellido: ");
				var apellido = consola.nextLine();
				logger.info("Ingrese su telefono: ");
				var telefono = consola.nextLine();
				logger.info("Ingrese su correo: ");
				var correo = consola.nextLine();
				logger.info("Ingrese su genero: ");
				var genero = consola.nextLine();
				logger.info("Ingrese su edad: ");
				var edad = Integer.parseInt(consola.nextLine());
				var estudiante = new Estudiante();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setCorreo(correo);
				estudianteService.guardarEstudiante(estudiante);
				logger.info("Cliente agregado"+sl+estudiante +sl);
			}
			case 4 -> {
				logger.info(sl + "*** Modificar Cliente ***" + sl);
				logger.info("Ingrese el codigo del Cliente a editar");
				var codigo = Integer.parseInt(consola.nextLine());
				Estudiante estudiante = estudianteService.buscarEstudiantePorId(codigo);
				if (estudiante != null){
					logger.info("Ingrese su nombre: ");
					var nombre = consola.nextLine();
					logger.info("Ingrese su apellido: ");
					var apellido = consola.nextLine();
					logger.info("Ingrese su correo: ");
					var correo = consola.nextLine();
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setCorreo(correo);
					estudianteService.guardarEstudiante(estudiante);
					logger.info("Cliente modifcado: "+sl+estudiante +sl);
				} else {
					logger.info("Cliente no encontrado; "+sl + estudiante +sl);
				}
			}
			case 5 -> {
				logger.info(sl+"*** Eliminar cliente ***"+sl);
				logger.info("Ingrese el codigo del cliente a eliminar");
				var codigo = Integer.parseInt(consola.nextLine());
				var estudiante = estudianteService.buscarEstudiantePorId(codigo);
				if (estudiante != null){
					estudianteService.eliminarEstudiante(estudiante);
					logger.info("Cliente eliminado, adios "+sl + estudiante +sl);
				} else {
					logger.info("Cliente NO encontrado "+sl + estudiante +sl);
				}
			}
			case 6 -> {
				logger.info("Hasta Pronto Vaquero!O" + sl + sl);
				salir = true;

			}
			default -> logger.info("Opcion no valida!!");
		}

		return false;
	}
}
