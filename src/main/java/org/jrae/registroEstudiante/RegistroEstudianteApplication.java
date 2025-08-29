package org.jrae.registroEstudiante;

import org.jrae.registroEstudiante.dominio.service.CursoService;
import org.jrae.registroEstudiante.dominio.service.EstudianteService;
import org.jrae.registroEstudiante.dominio.service.IEstudianteService;
import org.jrae.registroEstudiante.dominio.service.ICursosService;
import org.jrae.registroEstudiante.dominio.service.InfoEstudiante;
import org.jrae.registroEstudiante.dominio.service.InfoCursos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RegistroEstudianteApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistroEstudianteApplication.class);
    }
}
