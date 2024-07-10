package dev.lucasmoy.curso.service;

import dev.lucasmoy.curso.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();
    UserDTO findUserById(Long id);
    void createUser(UserDTO userDTO);
    void delete(Long id);
    void update(Long id, UserDTO userDTO);
}
