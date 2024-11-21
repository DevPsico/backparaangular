package com.ericsonangular.ericsonangular.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsonangular.ericsonangular.models.Usuario;
import com.ericsonangular.ericsonangular.repositorys.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void instanciaDB() {
		
		Usuario user1 = new Usuario(null, "abc", "123");
		Usuario user2 = new Usuario(null, "ericson", "123");
		
		this.usuarioRepository.saveAll(Arrays.asList(user1, user2));
		
	}
}
