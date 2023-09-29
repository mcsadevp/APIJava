package org.api.api.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table // Relacion onetomany
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usuarioId;

    @NotNull(message = "Porfavor ingresa nombre de ususario")
    @Size(min = 2, max=15 )
    @Column(name = "nombreUsuario")
    private String nameUser;


    @Email(message = "Porfavor ingresa un Email valido")
    @Column(name = "emailUsuario")
    private String email;

    @OneToMany
    @JsonIgnore
    private List<Tarea> usuarioTarea;

    @ManyToOne
    @JoinColumn(name = "usuarioId", nullable = false)
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL)
    private List<Comentario> tareaComentario;


}
