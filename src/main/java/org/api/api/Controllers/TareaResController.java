package org.api.api.Controllers;

import org.api.api.Models.Tarea;
import org.api.api.Models.Usuario;
import org.api.api.Services.TareaService;
import org.api.api.Services.TareaServiceImple;
import org.api.api.Services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
public class TareaResController {
    @Autowired
    TareaServiceImple tareaService;

    @GetMapping("/agrega")
    public Tarea newTarea (@RequestBody Tarea tareaNueva){
        Tarea tareaSave = tareaService.agregaTarea(tareaNueva);
        return tareaSave;
    }
    @DeleteMapping("/borrar/{id}")
    public  String deleteTarea(@PathVariable Long id){
        tareaService.borrarTarea(id);
        return "Tarea eliminado";
    }
    @GetMapping("/lista")
    public List<Tarea> listaTarea(){
        List<Tarea> tareaMostrar = tareaService.listaTarea();
        return tareaMostrar;
    }
    @GetMapping("/{id}")
    public Tarea buscarTareaPorId(@PathVariable Long id){
        Tarea tareaMostrar = tareaService.buscarTareaPorId(id);
        return tareaMostrar;
    }

    @PutMapping("/editar/{id}")
    public Tarea editarUsuarioPorId(@PathVariable Long id, @RequestBody Tarea tareaActualizada){
        Tarea tareaEditada = tareaService.editarTareaPorId(id, tareaActualizada);
        return tareaActualizada;
    }

}
