package dev.lucasmoy.curso.service;

import dev.lucasmoy.curso.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> findAllUsuarios();
    Usuario findUsuarioById(Long id);
    Usuario crearUsuario(Usuario usuario);
    void delete(Long id);
    Usuario update(Long id, Usuario usuario);
}
