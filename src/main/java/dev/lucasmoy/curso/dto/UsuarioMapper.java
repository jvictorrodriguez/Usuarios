package dev.lucasmoy.curso.dto;

import dev.lucasmoy.curso.model.Usuario;

public class UsuarioMapper {

    private UsuarioMapper() {
        throw new IllegalStateException("Utility class");
    }


    public static UsuarioDto toUsuarioDto(Usuario usuario){
        return new UsuarioDto(
                usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getEmail(),
                usuario.getTelefono(),
                usuario.getPassword()
        );
    }

    public static Usuario toUsuario(UsuarioDto usuarioDto){
        return new Usuario(
                usuarioDto.nombre(),
                usuarioDto.apellidos(),
                usuarioDto.email(),
                usuarioDto.telefono(),
                usuarioDto.password()
        );
    }
}
