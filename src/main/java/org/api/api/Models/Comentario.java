package org.api.api.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table // Relacion manytoone
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long comentarioId;

    @NotNull
    @Size(max = 50, message = "No puedes superar los 50 caracteres")
    private String texto;

    @NotNull
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Column(name = "fecha de creacion")

    private String fechaC;

    @ManyToOne
    @JoinColumn(name = "tareaid", nullable = false)
    private Tarea tarea;




}
