package dev.lucasmoy.curso.dto;

public record UsuarioDto(
        String nombre,
        String apellidos,
        String email,
        String telefono,
        String password
        ) {
}
