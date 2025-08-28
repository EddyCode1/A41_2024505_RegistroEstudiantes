package org.jrae.registroEstudiante.dominio.service;

import org.jrae.registroEstudiante.persistence.entity.Cursos;

import java.util.List;

public interface ICursosService {
    List<Cursos> listarCursos();
    Cursos buscarCursoPorNombre(String nombreCurso);
    void guardarCurso(Cursos cursos);
    void eliminarCurso(Cursos cursos);
    void asignarEstudianteACurso(Integer codigoCurso, Integer codigoEstudiante);

}
