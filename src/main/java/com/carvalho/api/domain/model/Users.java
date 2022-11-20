/**
 * 
 */
package com.carvalho.api.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@Table(name = "tb_users")
public class Users {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank
	@Column(name = "user_name")
	private String nameUser;
	@NotNull
	@NotBlank
	@Email
	@Column(name = "user_email")
	private String email;
	@NotNull
	@NotBlank
	@Column(name = "user_phone")
	private String phone;
	
	/**
	private String cpf;
	private String password;
	**/

}
