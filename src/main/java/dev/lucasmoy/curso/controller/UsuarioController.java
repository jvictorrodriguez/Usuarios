package dev.lucasmoy.curso.controller;

import dev.lucasmoy.curso.dto.UsuarioDto;
import dev.lucasmoy.curso.model.Usuario;
import dev.lucasmoy.curso.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.findAllUsuarios());
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.findUsuarioById(id));
    }

    @PostMapping()
    public ResponseEntity<UsuarioDto> crearUsuario(@Valid @RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioCreadoDto = usuarioService.crearUsuario(usuarioDto);
        return ResponseEntity.ok(usuarioCreadoDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.update(id, usuario));
    }
}
