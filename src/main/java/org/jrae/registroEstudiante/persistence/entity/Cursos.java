package org.jrae.registroEstudiante.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

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
}
