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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.carvalho.api.domain.IValidationGroups;

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
@Table(name = "tb_clientstest")
public class ClientTest {
	
	@NotNull(groups = IValidationGroups.ClientTestId.class)
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Users user;
	
	@NotBlank
	@Size(max=60)
	@Column(name = "nome")
	private String nome;
	
	@NotBlank
	@Email
	@Size(max=255)
	@Column(name = "email")
	private String email;
	
	@NotBlank
	@Size(max=20)
	@Column(name = "fone")
	private String fone;
}
