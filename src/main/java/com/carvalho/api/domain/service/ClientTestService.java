/**
 * 
 */
package com.carvalho.api.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carvalho.api.domain.exception.DomainException;
import com.carvalho.api.domain.model.ClientTest;
import com.carvalho.api.domain.repository.IClientTestRepository;

import lombok.AllArgsConstructor;

/**
 * manoel.carvalho
 *
 */

@AllArgsConstructor
@Service
public class ClientTestService {
	
	private IClientTestRepository clientTestRepository;
	
	
	public ClientTest search(Long clientId) {
		return clientTestRepository.findById(clientId)
			   .orElseThrow(() -> new DomainException("Cliente não encontrado"));
	}
	
	@Transactional
	public ClientTest createClient(ClientTest client) {
		boolean emailEmUso = clientTestRepository.findByEmail(client.getEmail())
			   .stream()
			   .anyMatch(clientExist -> !clientExist.equals(client));
		
		if (emailEmUso) {
			throw new DomainException("Já existe um cliente cadastrado com esse e-mail.");
		}
		return clientTestRepository.save(client);
		
	}
	
	@Transactional
	public boolean deleteId(Long clientId) {
		return clientTestRepository.existsById(clientId);
	}
	
	@Transactional
	public void deleteClient(Long clientId) {
		clientTestRepository.deleteById(clientId);
	}
	

}
