package org.jrae.registroEstudiante.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Estudiante")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoEstudiante; // permite usar null en vez de 0 el Integer
    @Column
    private String nombre;
    private String apellido;
    private String correo;
}
