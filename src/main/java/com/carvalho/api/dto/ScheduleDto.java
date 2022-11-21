/**
 * 
 */
package com.carvalho.api.dto;

import java.time.OffsetDateTime;



import com.carvalho.api.domain.model.StatusSchedule;



import lombok.Getter;
import lombok.Setter;

/**
 * manoel.carvalho
 *
 */

@Getter
@Setter
public class ScheduleDto {

	
	private Long id;
	private String nomeCliente;
	private String nameUserCliente;
	private StatusSchedule status;
	private OffsetDateTime dateScheduling;
	private OffsetDateTime dateFinishing;
	private String dateSchedulingClient;
	private String timeSchedulingClient;
	
	
	
}
