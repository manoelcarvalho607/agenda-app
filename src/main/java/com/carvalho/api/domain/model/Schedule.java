/**
 * 
 */
package com.carvalho.api.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "tb_schedules")
public class Schedule {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Clients client;
	
	@Enumerated(EnumType.STRING)
	private StatusSchedule status;
	@Column(name = "date_request")
	private LocalDateTime dateScheduling;
	@Column(name = "date_finishing")
	private LocalDateTime dateFinishing;
	@Column(name = "date_scheduling_client")
	private String dateSchedulingClient;
	@Column(name = "time_scheduling_client")
	private String timeSchedulingClient;

}
