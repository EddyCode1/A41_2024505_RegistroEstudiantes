package org.jrae.registroEstudiante.dominio.service;

import org.jrae.registroEstudiante.persistence.entity.Cursos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Scanner;

public class InfoCursos {
/*
    private final ICursosService cursosService;
    private static final Logger logger = LoggerFactory.getLogger(InfoCursos.class);
    private final String sl = System.lineSeparator();

    public InfoCursos(ICursosService cursosService) {
        this.cursosService = cursosService;
    }

    public void menuCursos() {
        Scanner consola = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            logger.info("""
                    \n *****Gestión de Cursos*****
                    1. Listar Todos los Cursos
                    2. Buscar Curso por nombre
                    3. Agregar Nuevo Curso
                    4. Modificar Curso
                    5. Eliminar Curso
                    6. Asignar Estudiante a un Curso 
                    7. Salir
                    Ejecutar una opción: """);

            int opcion = Integer.parseInt(consola.nextLine());
            salir = ejecutarOpciones(consola, opcion);
            logger.info(sl);
        }
    }

    private boolean ejecutarOpciones(Scanner consola, int opcion) {
        boolean salir = false;

        switch (opcion) {
            case 1 -> {
                logger.info(sl + "***Listado de todos los cursos***" + sl);
                List<Cursos> cursos = cursosService.listarCursos();
                cursos.forEach(curso -> logger.info(curso.toString() + sl));
            }
            case 2 -> {
                logger.info(sl + "Buscar Curso por nombre ***" + sl);
                String nombre = consola.nextLine();
                Cursos curso = cursosService.buscarCursoPorNombre(nombre);

                if (curso != null) {
                    logger.info("Curso encontrado:" + sl + curso + sl);
                } else {
                    logger.info("Curso no encontrado." + sl);
                }
            }
            case 3 -> {
                logger.info(sl + "*** Agregar nuevo Curso ****" + sl);
                logger.info("Ingrese el nombre del curso: ");
                String nombre = consola.nextLine();

                Cursos curso = new Cursos();
                curso.setNombreCurso(nombre);

                cursosService.guardarCurso(curso);
                logger.info("Curso agregado:" + sl + curso + sl);
            }
            case 4 -> {
                logger.info(sl + "*** Modificar Curso ***" + sl);
                logger.info("Ingrese el nombre del curso a editar: ");
                String nombre = consola.nextLine();
                Cursos curso = cursosService.buscarCursoPorNombre(nombre);
                if (curso != null) {
                    logger.info("Ingrese el nuevo nombre: ");
                    String nuevoNombre = consola.nextLine();
                    curso.setNombreCurso(nuevoNombre);
                    cursosService.guardarCurso(curso);
                    logger.info("Curso modificado:" + sl + curso + sl);
                } else {
                    logger.info("Curso no encontrado." + sl);
                }
            }
            case 5 -> {
                logger.info(sl + "*** Eliminar Curso ***" + sl);
                logger.info("Ingrese el nombre del curso a eliminar: ");
                String nombre = consola.nextLine();
                Cursos curso = cursosService.buscarCursoPorNombre(nombre);
                if (curso != null) {
                    cursosService.eliminarCurso(curso);
                    logger.info("Curso eliminado:" + sl + curso + sl);
                } else {
                    logger.info("Curso no encontrado." + sl);
                }
            }
            case 6 -> {
                logger.info(sl + "*** Asignar estudiante a un curso ***" + sl);
                logger.info("Ingrese el código del curso: ");
                Integer codigoCurso = Integer.parseInt(consola.nextLine());
                logger.info("Ingrese el código del estudiante: ");
                Integer codigoEstudiante = Integer.parseInt(consola.nextLine());
                cursosService.asignarEstudianteACurso(codigoCurso, codigoEstudiante);
                logger.info("Estudiante asignado al curso con éxito!" + sl);
            }

            case 7 -> {
                logger.info("Hasta pronto! " + sl);
                salir = true;
            }
            default -> logger.info("Opción no válida!!" + sl);
        }

        return salir;
    }*/
}
