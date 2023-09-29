package org.api.api.Services;

import org.api.api.Models.Comentario;
import org.api.api.Models.Usuario;
import org.api.api.Repositories.ComentarioRepository;
import org.api.api.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImpl implements ComentarioService{

    @Autowired
    ComentarioRepository comentarioRepository;

    @Override
    public Comentario agregaComentario(Comentario nuevoComentario) {
        return comentarioRepository.save(nuevoComentario);
    }

    @Override
    public void BorrarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }

    @Override
    public List<Comentario> listaComentario(Long id) {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario buscarComentarioPorid(Long id) {
        Boolean existe = comentarioRepository.existsById(id);
        if (existe){
            Comentario comentarioElegido = comentarioRepository.findById(id).get();
            return comentarioElegido;
        }else {
            System.out.println("Comentario invalido");
            return  null;
        }
    }

    @Override
    public Comentario editarComentarioPorId(Long id, Comentario comentarioActualizado) {
        Boolean existe = comentarioRepository.existsById(id);
        if (existe){
            Comentario comentarioElegido = comentarioRepository.findById(id).get();
            comentarioElegido.setTexto(comentarioActualizado.getTexto());
            comentarioElegido.setFechaC(comentarioActualizado.getFechaC());
            System.out.println("Comentario actualizado");
            return comentarioRepository.save(comentarioElegido);
        }else {
            System.out.println("Comentario invalido");
            return null;
        }
    }


}

