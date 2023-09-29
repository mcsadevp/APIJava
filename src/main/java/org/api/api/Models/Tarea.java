package org.api.api.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table // Relacion manytoone
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tareaId;

    @Size(min = 5 , max = 20)
    @NotNull
    private String tarea;

    @Size(min = 5 , max = 30)
    @NotNull
    private  String descripcion;

    @NotNull
    @Column(name = "Fecha de vencimiento")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date fechaV;



}
