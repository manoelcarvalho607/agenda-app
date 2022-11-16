/**
 * 
 */
package com.carvalho.api.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * manoel.carvalho
 *
 */

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name = "tb_clients")
public class Clients {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Users user;
	
	@NotBlank
	@Size(max=60)
	@Column(name = "client_name")
	private String nome;
	@NotBlank
	@Email
	@Size(max=255)
	@Column(name = "client_email")
	private String email;
	@NotBlank
	@Size(max=20)
	@Column(name = "client_phone")
	private String phone;

}
