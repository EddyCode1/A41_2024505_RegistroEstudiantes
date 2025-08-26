package org.jrae.registroEstudiante.dominio.service;

import org.jrae.registroEstudiante.persistence.entity.Estudiante;
import org.jrae.registroEstudiante.dominio.service.IEstudianteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class InfoEstudiante {

    private final IEstudianteService estudianteService;
    private static final Logger logger = LoggerFactory.getLogger(InfoEstudiante.class);
    private final String sl = System.lineSeparator();
    private final Scanner consola = new Scanner(System.in);


    public InfoEstudiante(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }


    public void ejecutar() {
        logger.info("******Aplicación de Registro de Estudiantes*******");
        boolean salir = false;

        while (!salir) {
            int opcion = mostrarMenu();
            salir = ejecutarOpciones(opcion);
            logger.info(sl);
        }
    }

    private int mostrarMenu() {
        logger.info("""
                \n *****Gestión de Estudiantes*****
                1. Listar Todos los Estudiantes
                2. Buscar Estudiante por código
                3. Agregar Nuevo Estudiante
                4. Modificar Estudiante
                5. Eliminar Estudiante
                6. Salir
                Ejecutar una opción: """);
        return Integer.parseInt(consola.nextLine());
    }

    private boolean ejecutarOpciones(int opcion) {
        boolean salir = false;

        switch (opcion) {
            case 1 -> {
                logger.info(sl + "***Listado de todos los estudiantes***" + sl);
                List<Estudiante> estudiantes = estudianteService.listarEstudiantes();
                estudiantes.forEach(estudiante -> logger.info(estudiante.toString() + sl));
            }
            case 2 -> {
                logger.info(sl + "Buscar Estudiante por su código ***" + sl);
                logger.info("Ingrese código del estudiante: ");
                int codigo = Integer.parseInt(consola.nextLine());
                Estudiante estudiante = estudianteService.buscarEstudiantePorId(codigo);
                if (estudiante != null) {
                    logger.info("Estudiante encontrado:" + sl + estudiante + sl);
                } else {
                    logger.info("Estudiante no encontrado." + sl);
                }
            }
            case 3 -> {
                logger.info(sl + "*** Agregar nuevo Estudiante ****" + sl);
                logger.info("Ingrese su nombre: ");
                String nombre = consola.nextLine();
                logger.info("Ingrese su apellido: ");
                String apellido = consola.nextLine();
                logger.info("Ingrese su correo: ");
                String correo = consola.nextLine();

                Estudiante estudiante = new Estudiante();
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);
                estudiante.setCorreo(correo);

                estudianteService.guardarEstudiante(estudiante);
                logger.info("Estudiante agregado:" + sl + estudiante + sl);
            }
            case 4 -> {
                logger.info(sl + "*** Modificar Estudiante ***" + sl);
                logger.info("Ingrese el código del estudiante a editar: ");
                int codigo = Integer.parseInt(consola.nextLine());
                Estudiante estudiante = estudianteService.buscarEstudiantePorId(codigo);
                if (estudiante != null) {
                    logger.info("Ingrese su nombre: ");
                    String nombre = consola.nextLine();
                    logger.info("Ingrese su apellido: ");
                    String apellido = consola.nextLine();
                    logger.info("Ingrese su correo: ");
                    String correo = consola.nextLine();

                    estudiante.setNombre(nombre);
                    estudiante.setApellido(apellido);
                    estudiante.setCorreo(correo);

                    estudianteService.guardarEstudiante(estudiante);
                    logger.info("Estudiante modificado:" + sl + estudiante + sl);
                } else {
                    logger.info("Estudiante no encontrado." + sl);
                }
            }
            case 5 -> {
                logger.info(sl + "*** Eliminar Estudiante ***" + sl);
                logger.info("Ingrese el código del estudiante a eliminar: ");
                int codigo = Integer.parseInt(consola.nextLine());
                Estudiante estudiante = estudianteService.buscarEstudiantePorId(codigo);
                if (estudiante != null) {
                    estudianteService.eliminarEstudiante(estudiante);
                    logger.info("Estudiante eliminado:" + sl + estudiante + sl);
                } else {
                    logger.info("Estudiante no encontrado." + sl);
                }
            }
            case 6 -> {
                logger.info("Hasta pronto! " + sl);
                salir = true;
            }
            default -> logger.info("Opción no válida!!" + sl);
        }
        return salir;
    }
}
