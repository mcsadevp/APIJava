package org.api.api.Services;

import org.api.api.Models.Comentario;

import java.util.List;

public interface ComentarioService {
    Comentario agregaComentario(Comentario nuevoComentario);
    void BorrarComentario(Long id);
    List<Comentario> listaComentario();
    Comentario buscarComentarioPorid(Long id);
    Comentario editarComentarioPorId(Long id, Comentario comentarioActualizado);






}
