package com.ericsonangular.ericsonangular.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ericsonangular.ericsonangular.dtos.UsuarioDTO;
import com.ericsonangular.ericsonangular.exceptions.ObjectNotFoundException;
import com.ericsonangular.ericsonangular.models.Usuario;
import com.ericsonangular.ericsonangular.repositorys.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	

	public Usuario findById(Integer id) {

		Optional<Usuario> usuario = usuarioRepository.findById(id);

		return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado !!!"));
	}

	public List<Usuario> findAll() {

		List<Usuario> listaUsuario = usuarioRepository.findAll();

		if (listaUsuario.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado !!!!");
		}
		
		return listaUsuario;

	}

	public Usuario save(UsuarioDTO usuarioDTO) {

		usuarioDTO.setId(null);

		return usuarioRepository.save(new Usuario(usuarioDTO));
	}

	public Usuario update(Integer id, UsuarioDTO usuarioDTO) {

		Usuario usuario = findById(id);

		usuarioDTO.setId(usuario.getId());

		return usuarioRepository.save(new Usuario(usuarioDTO));
	}

	public void delete(Integer id) {
		findById(id);

		usuarioRepository.deleteById(id);
	}

}
