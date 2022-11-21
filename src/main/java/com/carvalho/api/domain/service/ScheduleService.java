/**
 * 
 */
package com.carvalho.api.domain.service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carvalho.api.domain.exception.DomainException;
import com.carvalho.api.domain.model.Schedule;
import com.carvalho.api.domain.model.ClientTest;
import com.carvalho.api.domain.model.StatusSchedule;
import com.carvalho.api.domain.repository.IScheduleRepository;
import com.carvalho.api.domain.repository.IClientTestRepository;

import lombok.AllArgsConstructor;

/**
 * manoel.carvalho
 *
 */
@AllArgsConstructor
@Service
public class ScheduleService {
	
	private ClientTestService clientTestService;
	private IScheduleRepository agendaRepository;
	
	
	
	@Transactional
	public Schedule createScheduling(Schedule agenda) {
		ClientTest client = clientTestService.search(agenda.getCliente().getId());
		
		
		agenda.setCliente(client);
		agenda.setStatus(StatusSchedule.PENDENTE);
		agenda.setDateScheduling(OffsetDateTime.now());
		
		//implementar regras de uso. ex horário de disponivel p agendamento.
		
		return agendaRepository.save(agenda);
	}

}
