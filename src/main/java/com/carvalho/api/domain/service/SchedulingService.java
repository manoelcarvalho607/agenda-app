/**
 * 
 */
package com.carvalho.api.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carvalho.api.domain.model.Schedule;
import com.carvalho.api.domain.model.StatusSchedule;
import com.carvalho.api.domain.repository.IScheduleRepository;

import lombok.AllArgsConstructor;

/**
 * manoel.carvalho
 *
 */
@AllArgsConstructor
@Service
public class SchedulingService {

	private IScheduleRepository scheduleRepository;
	
	@Transactional
	public Schedule requestScheduling(Schedule schedule) {
		schedule.setStatus(StatusSchedule.PENDENTE);
		schedule.setDateScheduling(LocalDateTime.now());
		
		//implementar regras de uso. ex horário de disponivel p agendamento.
		
		
		return scheduleRepository.save(schedule);
	}
	
	
}
