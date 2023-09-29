package org.api.api.Controllers;

import org.api.api.Models.Usuario;
import org.api.api.Services.UsuarioService;
import org.api.api.Services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioResController {
    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/agrega")
    public  Usuario newUsuario (@RequestBody Usuario usuarioNuevo){
    Usuario usuarioSave = usuarioService.agregaUsuario(usuarioNuevo);
    return usuarioSave;
    }
    @DeleteMapping("/borrar/{id}")
    public  String deleteUsuario(@PathVariable Long id){
        usuarioService.borrarUsuario(id);
        return "Usuario eliminado";
    }
    @GetMapping("/lista")
    public List<Usuario> listaUsuarios(){
        List<Usuario> listaMostrar = usuarioService.listaUsuarios();
        return listaMostrar;
    }
    @GetMapping("/{id}")
    public Usuario buscarusuarioPorId(@PathVariable Long id){
        Usuario usuarioMostrar = usuarioService.buscarUsurioPorId(id);
        return usuarioMostrar;
    }

    @PutMapping("/editar/{id}")
    public Usuario editarUsuarioPorId(@PathVariable Long id, @RequestBody Usuario usuarioActualizado){
        Usuario usuarioEditado = usuarioService.editarUsuarioPorId(id, usuarioActualizado);
        return usuarioEditado;
    }


}
