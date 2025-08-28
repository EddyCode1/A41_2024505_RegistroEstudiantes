package org.jrae.registroEstudiante.dominio.service;

import org.jrae.registroEstudiante.persistence.entity.Estudiante;

import java.util.List;

public interface IEstudianteService {
    List<Estudiante> listarEstudiantes();
    Estudiante buscarEstudiantePorNombre(String Estudiante);
    Estudiante buscarEstudiantePorId(Integer codigo);
    void guardarEstudiante(Estudiante estudiante);
    void eliminarEstudiante(Estudiante estudiante);
}
