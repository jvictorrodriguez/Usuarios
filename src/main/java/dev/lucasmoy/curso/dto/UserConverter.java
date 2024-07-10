package dev.lucasmoy.curso.dto;

import dev.lucasmoy.curso.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {


    public UserDTO toUsuarioDto(User user){
        return new UserDTO(
                user.getId(),
                user.getNombre(),
                user.getApellidos(),
                user.getEmail(),
                user.getTelefono(),
                user.getPassword()
        );
    }

    public User toUsuario(UserDTO userDTO){
        return new User(
                userDTO.nombre(),
                userDTO.apellidos(),
                userDTO.email(),
                userDTO.telefono(),
                userDTO.password()
        );
    }

}
