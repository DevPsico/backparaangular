package com.ericsonangular.ericsonangular.dtos;

import com.ericsonangular.ericsonangular.models.Usuario;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UsuarioDTO {
	
		private Integer id;
		@NotEmpty(message = "O campo nome é obrigatório !")
		private String nomeUsuario;
		@NotEmpty(message = "O campo senha é obrigatório !")
		private String senha;
		
		
		public UsuarioDTO() {
			super();
		}


		public UsuarioDTO(Integer id, String nomeUsuario, String senha) {
			super();
			this.id = id;
			this.nomeUsuario = nomeUsuario;
			this.senha = senha;
		}
		
		public UsuarioDTO(Usuario usuario) {
			this.id = usuario.getId();
			this.nomeUsuario = usuario.getNomeUsuario();
			this.senha = usuario.getSenha();
		}
	}