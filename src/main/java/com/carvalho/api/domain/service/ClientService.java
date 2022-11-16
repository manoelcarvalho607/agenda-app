/**
 * 
 */
package com.carvalho.api.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carvalho.api.domain.exception.DomainException;
import com.carvalho.api.domain.model.Clients;
import com.carvalho.api.domain.repository.IClientRepository;
import com.carvalho.api.dto.ClientDto;

/**
 * manoel.carvalho
 *
 */
@Service
public class ClientService {
	
	private IClientRepository clientRepository;
	
	
	public ClientService(IClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	
	
	@Transactional
	public Clients saveClient(Clients client) {
		boolean emailEmUso = clientRepository.findByEmail(client.getEmail())
				             .stream()    
				             .anyMatch(clientExist -> !clientExist.equals(client));
		
		if (emailEmUso) {
			throw new DomainException("Já existe um cliente cadastrado com esse e-mail.");
		}
		
		return clientRepository.save(client);
	}
	
	@Transactional
	public boolean deleteId(Long clientId) {
		return clientRepository.existsById(clientId);
	}
	
	@Transactional
	public void deleteClient(Long clientId) {
		clientRepository.deleteById(clientId);
	}
	

}
