/**
 * 
 */
package com.carvalho.api.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.carvalho.api.domain.model.Clients;
import com.carvalho.api.domain.repository.IClientRepository;
import com.carvalho.api.domain.service.ClientService;

import lombok.AllArgsConstructor;



/**
 * manoel.carvalho
 *
 */

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/clients")
public class ClientController {
	
	
	private IClientRepository clientRepository;
	private ClientService clientService;
	
	
	
	@GetMapping
	public List<Clients> list() {
		return clientRepository.findAll();
	}
	
	
	@GetMapping("/{clientId}")
	public ResponseEntity<Clients>  read(@PathVariable Long clientId) {
		return clientRepository.findById(clientId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
		
		
	//	Optional<Clients> client = clientRepository.findById(clientId);
	//	if(client.isPresent()) {
	//		return ResponseEntity.ok(client.get());
	//	}
	//	return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Clients create(@Valid @RequestBody Clients client) {
		//return clientRepository.save(client);
		return clientService.saveClient(client);
	}
	
	@PutMapping("/{clientId}")
	public ResponseEntity<Clients> update(@Valid @PathVariable Long clientId, 
			@RequestBody Clients client) {
		if (!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		client.setId(clientId);
		client = clientService.saveClient(client);
		 
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> delete(@PathVariable Long clientId) {
		if (!clientService.deleteId(clientId)) {
			return ResponseEntity.notFound().build();
		}
		
		
		clientService.deleteClient(clientId);
		return ResponseEntity.noContent().build();
	}

}
