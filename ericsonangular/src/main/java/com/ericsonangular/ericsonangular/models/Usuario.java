package com.ericsonangular.ericsonangular.models;

import com.ericsonangular.ericsonangular.dtos.UsuarioDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeUsuario;
	private String senha;
	
	
	public Usuario() {
		super();
	}


	public Usuario(Integer id, String nomeUsuario, String senha) {
		super();
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}
	
	public Usuario(UsuarioDTO usuarioDTO) {
		this.id = usuarioDTO.getId();
		this.nomeUsuario = usuarioDTO.getNomeUsuario();
		this.senha = usuarioDTO.getSenha();
	}
	
	
	

}
