/**
 * 
 */
package com.carvalho.api.domain.model;




import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.carvalho.api.domain.IValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * manoel.carvalho
 *
 */


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_agenda")
public class Schedule {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	@ConvertGroup(from = Default.class, to = IValidationGroups.ClientTestId.class)
	@NotNull
	@ManyToOne
	private ClientTest cliente;
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private StatusSchedule status;
	
	@JsonProperty(access = Access.READ_ONLY)
	@Column(name = "date_request")
	private OffsetDateTime dateScheduling;
	
	@JsonProperty(access = Access.READ_ONLY)
	@Column(name = "date_finishing")
	private OffsetDateTime dateFinishing;
	
	@NotNull
	@Column(name = "date_scheduling_client")
	private String dateSchedulingClient;
	@NotNull
	@Column(name = "time_scheduling_client")
	private String timeSchedulingClient;

}
