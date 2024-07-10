package dev.lucasmoy.curso.service;

import dev.lucasmoy.curso.dto.UserConverter;
import dev.lucasmoy.curso.dto.UserDTO;
import dev.lucasmoy.curso.exception.UserNotFoundException;
import dev.lucasmoy.curso.model.User;
import dev.lucasmoy.curso.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String NOT_FOUND_MESSAGE = "User not found with id: ";

    private final UserRepository userRepository;
    private final UserConverter converter;

    /**
     * Find a user by ID
     * @param id - the ID of the user
     * @return UserDTO - the user data transfer object
     */
    @Override
    public UserDTO findUserById(Long id) {
        log.info("Finding user with ID: {}", id);
        return userRepository.findById(id)
                .map(converter::toUsuarioDto)
                .orElseThrow(() -> {
                    log.warn("User with ID: {} not found", id);
                    return new UserNotFoundException(NOT_FOUND_MESSAGE + id);
                });
    }

    /**
     * Retrieve all users
     * @return List<UserDTO> - a list of user data transfer objects
     */
    @Override
    public List<UserDTO> findAll() {
        log.info("Fetching all users");
        List<UserDTO> users = userRepository.findAll().stream()
                .map(converter::toUsuarioDto)
                .toList();
        log.info("Total users found: {}", users.size());
        return users;
    }

    /**
     * Create a new user
     * @param userDTO - the user data transfer object
     */
    @Override
    public void createUser(UserDTO userDTO) {
        log.info("Creating a new user with details: {}", userDTO);
        User newUser = converter.toUsuario(userDTO);
        userRepository.save(newUser);
        log.info("New user created with ID: {}", newUser.getId());
    }

    /**
     * Delete a user by ID
     * @param id - the ID of the user to delete
     * @throws UserNotFoundException if the user is not found
     */
    @Override
    public void delete(Long id) {
        log.info("Deleting user with ID: {}", id);
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            log.info("User with ID: {} deleted successfully", id);
        } else {
            log.warn("User with ID: {} not found for deletion", id);
            throw new UserNotFoundException(NOT_FOUND_MESSAGE + id);
        }
    }

    /**
     * Update an existing user
     * @param id - the ID of the user to update
     * @param userDTOToUpdate - the user data transfer object with updated information
     * @throws UserNotFoundException if the user is not found
     */
    @Override
    public void update(Long id, UserDTO userDTOToUpdate) {
        log.info("Updating user with ID: {}", id);
        if (!userRepository.existsById(id)) {
            log.warn("User with ID: {} not found for update", id);
            throw new UserNotFoundException(NOT_FOUND_MESSAGE + id);
        }
        User userUpdated = converter.toUsuario(userDTOToUpdate);
        userUpdated.setId(id);
        userRepository.save(userUpdated);
        log.info("User with ID: {} updated successfully", id);
    }
}
