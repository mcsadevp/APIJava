package org.api.api.Services;

import org.api.api.Models.Tarea;
import org.api.api.Models.Usuario;

import java.util.List;

public interface TareaService {
    Tarea agregaTarea(Tarea tareaNueva);
    void borrarTarea(Long id);
    List<Tarea> listaTarea();
    Tarea buscarTareaPorId(Long id);
    Tarea editarTareaPorId(Long id, Tarea TareaActualizada);
}
