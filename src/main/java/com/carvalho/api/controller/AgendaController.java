/**
 * 
 */
package com.carvalho.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carvalho.api.domain.model.Agenda;
import com.carvalho.api.domain.repository.IAgendaRepository;
import com.carvalho.api.domain.service.AgendaService;

import lombok.AllArgsConstructor;

/**
 * manoel.carvalho
 *
 */

@AllArgsConstructor
@RestController
@RequestMapping("/agendamento")
public class AgendaController {
	
	private IAgendaRepository agendaRepository;
	private AgendaService agendaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Agenda createAgendamento(@RequestBody Agenda agenda) {
		return agendaService.createAgenda(agenda);
	}
	
	@GetMapping
	public List<Agenda> readAgenda() {
		return agendaRepository.findAll();
	}

}
