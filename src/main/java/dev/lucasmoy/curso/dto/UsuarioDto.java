package dev.lucasmoy.curso.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UsuarioDto(
        @NotBlank(message = "El nombre no puede estar en blanco")
        @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres")
        String nombre,

        @NotBlank(message = "Los apellidos no pueden estar en blanco")
        @Size(max = 50, message = "Los apellidos no pueden tener más de 50 caracteres")
        String apellidos,

        @NotBlank(message = "El correo electrónico no puede estar en blanco")
        @Email(message = "El correo electrónico debe ser válido")
        String email,

        @NotBlank(message = "El teléfono no puede estar en blanco")
        @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "El número de teléfono debe ser válido")
        String telefono,

        @NotBlank(message = "La contraseña no puede estar en blanco")
        @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
        String password
        ) {
}
