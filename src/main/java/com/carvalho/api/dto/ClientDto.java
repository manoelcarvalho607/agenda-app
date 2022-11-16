/**
 * 
 */
package com.carvalho.api.dto;

import javax.persistence.ManyToOne;

import com.carvalho.api.domain.model.Users;

import lombok.Getter;
import lombok.Setter;

/**
 * manoel.carvalho
 *
 */

@Getter
@Setter
public class ClientDto {
	
	private Long id;
	
	@ManyToOne
	private Users user;
	
	private String nome;
	private String email;
	private String senha;
	
	
	public ClientDto(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

}
