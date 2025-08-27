package org.jrae.registroEstudiante.dominio.service;

import org.jrae.registroEstudiante.persistence.crud.CursoCrud;
import org.jrae.registroEstudiante.persistence.entity.Cursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService implements ICursosService {

    @Autowired
    private CursoCrud crud;

    @Override
    public List<Cursos> listarCursos() {
        return crud.findAll();
    }

    @Override
    public Cursos buscarCursoPorNombre(String nombreCurso) {
        List<Cursos> cursos = crud.findByNombreCurso(nombreCurso);
        if (!cursos.isEmpty()) {
            return cursos.get(0);
        }
        return null;
    }

    @Override
    public void guardarCurso(Cursos cursos) {
        crud.save(cursos);
    }

    @Override
    public void eliminarCurso(Cursos cursos) {
        crud.delete(cursos);
    }
}
