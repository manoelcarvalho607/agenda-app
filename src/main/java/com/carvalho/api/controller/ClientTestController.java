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

import com.carvalho.api.domain.model.ClientTest;
import com.carvalho.api.domain.repository.IClientTestRepository;
import com.carvalho.api.domain.service.ClientTestService;

import lombok.AllArgsConstructor;

/**
 * manoel.carvalho
 *
 */

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/clientes")
public class ClientTestController {
	
	private ClientTestService clientTestService;
	private IClientTestRepository clientTestRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClientTest createClientTest(@Valid @RequestBody ClientTest client) {
		return clientTestService.createClient(client);
	}
	
	@GetMapping
	public List<ClientTest> readClientTest() {
		return clientTestRepository.findAll();
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<ClientTest>  readId(@PathVariable Long clienteId) {
		return clientTestRepository.findById(clienteId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<ClientTest> update(@Valid @PathVariable Long clienteId, 
			@RequestBody ClientTest client) {
		if (!clientTestRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		client.setId(clienteId);
		client = clientTestService.createClient(client);
		 
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> delete(@PathVariable Long clienteId) {
		if (!clientTestService.deleteId(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		
		clientTestService.deleteClient(clienteId);
		return ResponseEntity.noContent().build();
	}
	
	
}
