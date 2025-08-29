package org.jrae.registroEstudiante.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Cursos")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoCurso; // permite usar null en vez de 0 el Integer
    @Column
    private String nombreCurso;
    private Integer codigoEstudiante;
/*
    @OneToMany
    @JoinColumn(name = "codigoEstudiante", referencedColumnName = "codigoEstudiante", insertable = false, updatable = false)
    private List<Estudiante> estudiantesInscritos;*/

}
