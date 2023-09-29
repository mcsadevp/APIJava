package org.api.api.Services;

import org.api.api.Models.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario agregaUsuario(Usuario nuevoUsuario);
    void borrarUsuario(Long id);
    List<Usuario> listaUsuarios();
    Usuario buscarUsurioPorId(Long id);
    Usuario editarUsuarioPorId(Long id, Usuario usuarioActualizado);

}
