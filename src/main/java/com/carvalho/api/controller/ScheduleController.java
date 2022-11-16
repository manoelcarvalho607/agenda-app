/**
 * 
 */
package com.carvalho.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carvalho.api.domain.model.Schedule;
import com.carvalho.api.domain.service.SchedulingService;

import lombok.AllArgsConstructor;

/**
 * manoel.carvalho
 *
 */

@AllArgsConstructor
@RestController
@RequestMapping("/agendamentos")
public class ScheduleController {

	private SchedulingService schedulingService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Schedule requestSchedule(@RequestBody Schedule schedule) {
		return schedulingService.requestScheduling(schedule);
	}
}
