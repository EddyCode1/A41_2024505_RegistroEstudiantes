package org.jrae.registroEstudiante;

import org.jrae.registroEstudiante.dominio.service.CursoService;
import org.jrae.registroEstudiante.dominio.service.EstudianteService;
import org.jrae.registroEstudiante.dominio.service.IEstudianteService;
import org.jrae.registroEstudiante.dominio.service.InfoEstudiante;
import org.jrae.registroEstudiante.dominio.service.InfoCursos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RegistroEstudianteApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(RegistroEstudianteApplication.class, args);

		IEstudianteService estudianteService = context.getBean(EstudianteService.class);
		ICursosService cursosService = context.getBean(CursoService.class);

		InfoEstudiante infoEstudiante = new InfoEstudiante(estudianteService);
		// InfoCursos infoCursos = new InfoCursos(cursosService);

		Scanner consola = new Scanner(System.in);
		boolean salir = false;

		while (!salir) {
			System.out.println("""
                    \n *****Aplicación Principal*****
                    1. Gestión de Estudiantes
                    2. Gestión de Cursos
                    3. Salir
                    Ejecutar una opción: """);

			int opcion = Integer.parseInt(consola.nextLine());

			switch (opcion) {
				case 1 -> infoEstudiante.ejecutar();
				// case 2 -> infoCursos.menuCursos();
				case 3 -> salir = true;
				default -> System.out.println("Opción no válida!");
			}
		}

		System.out.println("Aplicación finalizada.");
	}
}