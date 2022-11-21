/**
 * 
 */
package com.carvalho.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carvalho.api.assembler.ScheduleAssembler;
import com.carvalho.api.domain.model.Schedule;
import com.carvalho.api.domain.repository.IScheduleRepository;
import com.carvalho.api.domain.service.ScheduleService;
import com.carvalho.api.dto.ScheduleDto;

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
	private ScheduleAssembler scheduleAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ScheduleDto createAgendamento(@Valid @RequestBody Schedule schedule) {
		Schedule scheduling = scheduleService.createScheduling(schedule);
		return  scheduleAssembler.toModel(scheduling);
	}
	
	@GetMapping
	public List<ScheduleDto> readAgenda() {
		return scheduleAssembler.toCollectionModel(scheduleRepository.findAll());
	}
	
	@GetMapping("/{scheduleId}")
	public ResponseEntity<ScheduleDto> search(@PathVariable Long scheduleId) {
		return scheduleRepository.findById(scheduleId)
			   .map(scheduling -> ResponseEntity.ok(scheduleAssembler.toModel(scheduling)))
			   .orElse(ResponseEntity.notFound().build());
	}
}
