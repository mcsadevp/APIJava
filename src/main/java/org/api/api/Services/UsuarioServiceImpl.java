package org.api.api.Services;

import org.api.api.Models.Usuario;
import org.api.api.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario agregaUsuario(Usuario nuevoUsuario) {
        return usuarioRepository.save(nuevoUsuario);
    }

    @Override
    public void borrarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> listaUsuarios() {
        return  usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsurioPorId(Long id) {
        Boolean existe = usuarioRepository.existsById(id);
        if (existe){
            Usuario usuarioselec = usuarioRepository.findById(id).get();
            return usuarioselec;
        }else {
            System.out.println("El Id es invalido");
            return null;
        }
    }

    @Override
    public Usuario editarUsuarioPorId(Long id, Usuario usuarioActualizado) {
        Boolean existe = usuarioRepository.existsById(id);
        if (existe){
            Usuario usuarioselec = usuarioRepository.findById(id).get();
            usuarioselec.setNameUser(usuarioActualizado.getNameUser());
            usuarioselec.setEmail(usuarioActualizado.getEmail());
            System.out.println("Usuario actualizado");
            return usuarioRepository.save(usuarioselec);
        }else {
            System.out.println("Id invalido");
            return null;
        }
    }


}

