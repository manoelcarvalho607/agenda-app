/**
 * 
 */
package com.carvalho.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.carvalho.api.domain.model.Schedule;
import com.carvalho.api.dto.ScheduleDto;

import lombok.AllArgsConstructor;

/**
 * manoel.carvalho
 *
 */

@AllArgsConstructor
@Component
public class ScheduleAssembler {
	
	private ModelMapper modelMapper;
	
	public ScheduleDto toModel(Schedule schedule) {
		return modelMapper.map(schedule, ScheduleDto.class);
	}
	
	public List<ScheduleDto> toCollectionModel(List<Schedule> schedule) {
		return schedule.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
}
