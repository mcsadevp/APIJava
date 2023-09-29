package org.api.api.Controllers;

import org.api.api.Models.Comentario;
import org.api.api.Models.Tarea;
import org.api.api.Services.ComentarioServiceImpl;
import org.api.api.Services.TareaServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioResController {
    @Autowired
    ComentarioServiceImpl comentarioService;

    @GetMapping("/agrega")
    public Comentario newComentario (@RequestBody Comentario comentarioNuevo){
        Comentario comentariosave = comentarioService.agregaComentario(comentarioNuevo);
        return comentariosave;
    }
    @DeleteMapping("/borrar/{id}")
    public  String deleteComentario(@PathVariable Long id){
        comentarioService.BorrarComentario(id);
        return "Comentario eliminado";
    }
    @GetMapping("/lista")
    public List<Comentario> listaComentario(){
        List<Comentario> listaMostrar = comentarioService.listaComentario();
        return listaMostrar;
    }

    @GetMapping("/{id}")
    public Comentario buscarComentarioPorId(@PathVariable Long id){
        Comentario comentarioMostrar = comentarioService.buscarComentarioPorid(id);
        return comentarioMostrar;
    }

    @PutMapping("/editar/{id}")
    public Comentario editarComentarioPorId(@PathVariable Long id, @RequestBody Comentario comentarioActualizada) {
        Comentario comentarioEditado = comentarioService.editarComentarioPorId(id, comentarioActualizada);
        return comentarioEditado;
    }
}
