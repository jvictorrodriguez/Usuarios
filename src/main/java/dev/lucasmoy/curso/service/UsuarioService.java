package dev.lucasmoy.curso.service;

import dev.lucasmoy.curso.dto.UsuarioDto;
import dev.lucasmoy.curso.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> findAllUsuarios();
    Usuario findUsuarioById(Long id);
    UsuarioDto crearUsuario(UsuarioDto usuarioDto);
    void delete(Long id);
    Usuario update(Long id, Usuario usuario);
}
