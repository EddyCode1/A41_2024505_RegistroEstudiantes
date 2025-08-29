package org.jrae.registroEstudiante.web.controller;


import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.slf4j.Logger;
import org.jrae.registroEstudiante.dominio.service.IEstudianteService;
import org.jrae.registroEstudiante.persistence.entity.Estudiante;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
@Data

public class EstudianteController implements Serializable{

    @Autowired
    private IEstudianteService estudianteService;

    private List<Estudiante> estudiantes;
    private Estudiante estudianteSeleccionado;
    private Estudiante estudianteBusqueda;

    private static final Logger logger = LoggerFactory.getLogger(EstudianteController.class);
    private final String sl = System.lineSeparator();

    @PostConstruct
    public void init() {
        estudianteSeleccionado = new Estudiante();
        estudianteBusqueda = new Estudiante();
        cargarEstudiantes();
    }

    public void cargarEstudiantes() {
        this.estudiantes = estudianteService.listarEstudiantes();
        this.estudiantes.forEach(estudiante -> logger.info(estudiante.toString() + sl));
    }


    public void prepararNuevoEstudiante() {
        this.estudianteSeleccionado = new Estudiante();
    }

    // Guardar o actualizar un estudiante
    public void guardarEstudiante() {
        if (estudianteSeleccionado != null) {
            estudianteService.guardarEstudiante(estudianteSeleccionado);
            cargarEstudiantes();  // refrescar lista
        }
    }


    public void editarEstudiante(Estudiante estudiante) {

        this.estudianteSeleccionado = estudiante;
    }

    public void eliminarEstudiante() {
        if (estudianteSeleccionado != null) {
            estudianteService.eliminarEstudiante(estudianteSeleccionado);
            cargarEstudiantes(); // Para refrescar la lista
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estudiante eliminado"));
        }
    }


    // Buscar estudiante por nombre
    public void buscarEstudiante() {
        if (estudianteBusqueda != null && estudianteBusqueda.getNombre() != null && !estudianteBusqueda.getNombre().isEmpty()) {
            Estudiante encontrado = estudianteService.buscarEstudiantePorNombre(estudianteBusqueda.getNombre());
            if (encontrado != null) {
                estudiantes = new ArrayList<>();
                estudiantes.add(encontrado);
            } else {
                logger.info("Estudiante no encontrado." + sl);
                estudiantes = new ArrayList<>(); // lista vacía si no se encuentra
            }
        }
    }

    public void limpiarBusqueda() {
        estudianteBusqueda.setNombre("");
        cargarEstudiantes();
    }

    public String ejecutar() {
        return "estudiante.xhtml?faces-redirect=true";
    }
}
