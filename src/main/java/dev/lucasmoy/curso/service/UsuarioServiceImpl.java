package dev.lucasmoy.curso.service;

import dev.lucasmoy.curso.exception.UserNotFoundException;
import dev.lucasmoy.curso.model.Usuario;
import dev.lucasmoy.curso.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;


    @Override
    public Usuario findUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Long id) {
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        }else{
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }

    @Override
    public Usuario update(Long id, Usuario usuarioUpdated) {
        if (usuarioRepository.existsById(id)){
            usuarioUpdated.setId(id);
            return usuarioRepository.save(usuarioUpdated);
        }
        throw new UserNotFoundException("User not found with id: " + id);
    }
}
