/**
 * 
 */
package com.carvalho.api.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carvalho.api.domain.model.Schedule;
import com.carvalho.api.domain.repository.IScheduleRepository;
import com.carvalho.api.domain.service.ScheduleService;

import lombok.AllArgsConstructor;

/**
 * manoel.carvalho
 *
 */

@AllArgsConstructor
@RestController
@RequestMapping("/agendamentos")
public class ScheduleController {
	
	private IScheduleRepository scheduleRepository;
	private ScheduleService scheduleService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Schedule createAgendamento(@Valid @RequestBody Schedule schedule) {
		return scheduleService.createScheduling(schedule);
	}
	
	@GetMapping
	public List<Schedule> readAgenda() {
		return scheduleRepository.findAll();
	}
	
	@GetMapping("/{scheduleId}")
	public ResponseEntity<Schedule> search(@PathVariable Long scheduleId) {
		return scheduleRepository.findById(scheduleId)
			   .map(ResponseEntity::ok)
			   .orElse(ResponseEntity.notFound().build());
	}
}
