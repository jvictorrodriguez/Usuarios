package dev.lucasmoy.curso.service;

import dev.lucasmoy.curso.dto.UsuarioDto;
import dev.lucasmoy.curso.dto.UsuarioMapper;
import dev.lucasmoy.curso.exception.UserNotFoundException;
import dev.lucasmoy.curso.model.Usuario;
import dev.lucasmoy.curso.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private static final String NOT_FOUND_MESSAGE = "User not found with id: ";
    private final UsuarioRepository usuarioRepository;



    @Override
    public Usuario findUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(NOT_FOUND_MESSAGE + id));
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioDto crearUsuario(UsuarioDto usuarioDto) {
        Usuario usuarioAGuardar = UsuarioMapper.toUsuario(usuarioDto);
        usuarioRepository.save(usuarioAGuardar);
        return usuarioDto;
    }

    @Override
    public void delete(Long id) {
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        }else{
            throw new UserNotFoundException(NOT_FOUND_MESSAGE + id);
        }
    }

    @Override
    public Usuario update(Long id, Usuario usuarioUpdated) {
        if (usuarioRepository.existsById(id)){
            usuarioUpdated.setId(id);
            return usuarioRepository.save(usuarioUpdated);
        }
        throw new UserNotFoundException(NOT_FOUND_MESSAGE + id);
    }
}
