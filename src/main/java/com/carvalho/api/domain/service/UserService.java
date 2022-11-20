/**
 * 
 */
package com.carvalho.api.domain.service;

import java.util.List;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carvalho.api.domain.exception.DomainException;
import com.carvalho.api.domain.model.Users;

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
		boolean emailEmUso = userRepository.findByEmail(user.getEmail())
				   .stream()
				   .anyMatch(userExist -> !userExist.equals(user));
			
			if (emailEmUso) {
				throw new DomainException("Já existe um usuário cadastrado com esse e-mail.");
			}
			
			
			
			return userRepository.save(user);
			
	}
	
	@Transactional
	public List<Users> searchUsers() {
		return userRepository.findAll();
	}

	
	@Transactional
	public void deleteClient(Long userId) {
		userRepository.deleteById(userId);
	}
	
}
