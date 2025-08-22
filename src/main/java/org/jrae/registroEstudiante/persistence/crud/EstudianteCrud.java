package org.jrae.registroEstudiante.persistence.crud;

import org.jrae.registroEstudiante.persistence.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudianteCrud extends JpaRepository<Estudiante, Integer> {

}
