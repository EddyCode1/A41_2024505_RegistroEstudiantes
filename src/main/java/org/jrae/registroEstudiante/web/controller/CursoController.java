package org.jrae.registroEstudiante.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.jrae.registroEstudiante.dominio.service.ICursosService;
import org.jrae.registroEstudiante.persistence.entity.Cursos;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@Data
@ViewScoped
public class CursoController{

    @Autowired
    ICursosService cursosService;
    private List<Cursos> cursos;
    private Cursos cursoSeleccionado;

    private static final Logger logger = LoggerFactory.getLogger(CursoController.class);
    String sl = System.lineSeparator();

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.cursos = this.cursosService.listarCursos();
        this.cursos.forEach(curso -> logger.info(curso.toString() + sl));
    }

    public void agregarCurso(){
        this.cursoSeleccionado = new Cursos();
    }

    public void guardarCurso(){
        logger.info("Curso guardar" + this.cursoSeleccionado);
        //Agregar (insertar)
        if (this.cursoSeleccionado.getCodigoCurso() == null ){
            this.cursosService.guardarCurso(this.cursoSeleccionado);
            this.cursos.add(this.cursoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Curso agregado"));
        }
        //Modificar(update)
        else {
            this.cursosService.guardarCurso(this.cursoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Curso Actualizado") );
        }
        // ocultar la ventana modal
        PrimeFaces.current().executeScript( "PF('venataModeloCurso').hide()");

        PrimeFaces.current().ajax().update("formulario-cursos:mensaje-emergente",
                "formulario-cursos:tabla-cursos");
        // Actualizar la tabla con un metodo AJAX
    }

    public void eliminarCurso(){
        //Mostrar em consola
        logger.info("Curso a eliminar" + this.cursosService);
        //Llamar a nuestro servicion de eliminar cliente
        this.cursosService.eliminarCurso(cursoSeleccionado);
        // Eliminarlo de la lista clientes
        this.cursos.remove(cursoSeleccionado);
        //limpear nuestro sercicio de eliminacion de Clientes
        this.cursoSeleccionado = null;
        //Enviar un mensaje emergente
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Curso eliminado"));
        // Actualizar la tabla cpm akas
        PrimeFaces.current().ajax().update("formulario-cursos:mensaje-emergente",
                "formulario-cursos:tabla-cursos");
    }

    public String ejecutar() {
        return "curso.xhtml?faces-redirect=true";
    }
}