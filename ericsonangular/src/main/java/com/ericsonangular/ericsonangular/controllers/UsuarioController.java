package com.ericsonangular.ericsonangular.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ericsonangular.ericsonangular.dtos.UsuarioDTO;
import com.ericsonangular.ericsonangular.models.Usuario;
import com.ericsonangular.ericsonangular.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id) {

		Usuario usuario = usuarioService.findById(id);

		return ResponseEntity.ok().body(new UsuarioDTO(usuario));
	}

	@GetMapping
	public ResponseEntity<?> findAll() {

		List<Usuario> listaUsuario = usuarioService.findAll();

		List<UsuarioDTO> listaUsuarioDTO = listaUsuario.stream().map(UsuarioDTO::new).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaUsuarioDTO);
	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody UsuarioDTO usuarioDTO) {

		usuarioDTO.setId(null);
		Usuario usuario = usuarioService.save(usuarioDTO);
		
		

		return ResponseEntity.ok().body(new UsuarioDTO(usuario));

	}

	@PutMapping
	public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @Valid @RequestBody UsuarioDTO usuarioDTO) {

		Usuario usuario = usuarioService.update(id, usuarioDTO);

		return ResponseEntity.ok().body(new UsuarioDTO(usuario));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		usuarioService.delete(id);

		return ResponseEntity.noContent().build();
	}
}