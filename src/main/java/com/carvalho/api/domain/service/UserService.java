/**
 * 
 */
package com.carvalho.api.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carvalho.api.domain.model.Users;
import com.carvalho.api.domain.repository.IScheduleRepository;
import com.carvalho.api.domain.repository.IUserRepository;

import lombok.AllArgsConstructor;

/**
 * manoel.carvalho
 *
 */

@AllArgsConstructor
@Service
public class UserService {
	
	private IUserRepository userRepository;
	
	@Transactional
	public Users createUser(Users user) {
		return userRepository.save(user);
	}

}
