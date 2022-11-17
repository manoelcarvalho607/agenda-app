/**
 * 
 */
package com.carvalho.api.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carvalho.api.domain.exception.DomainException;
import com.carvalho.api.domain.model.Agenda;
import com.carvalho.api.domain.model.ClientTest;
import com.carvalho.api.domain.model.StatusSchedule;
import com.carvalho.api.domain.repository.IAgendaRepository;
import com.carvalho.api.domain.repository.IClientTestRepository;

import lombok.AllArgsConstructor;

/**
 * manoel.carvalho
 *
 */
@AllArgsConstructor
@Service
public class AgendaService {
	
	private ClientTestService clientTestService;
	private IAgendaRepository agendaRepository;
	
	
	
	@Transactional
	public Agenda createAgenda(Agenda agenda) {
		ClientTest client = clientTestService.search(agenda.getCliente().getId());
		
		
		agenda.setCliente(client);
		agenda.setStatus(StatusSchedule.PENDENTE);
		agenda.setDateScheduling(LocalDateTime.now());
		
		//implementar regras de uso. ex horário de disponivel p agendamento.
		
		return agendaRepository.save(agenda);
	}

}
