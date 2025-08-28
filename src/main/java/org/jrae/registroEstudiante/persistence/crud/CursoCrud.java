package org.jrae.registroEstudiante.persistence.crud;

import org.jrae.registroEstudiante.persistence.entity.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoCrud extends JpaRepository<Cursos, Integer> {

    List<Cursos> findByNombreCurso(String nombre);
}