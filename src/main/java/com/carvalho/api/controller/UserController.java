/**
 * 
 */
package com.carvalho.api.controller;

import java.util.List;
import java.util.Optional;

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


import com.carvalho.api.domain.model.Users;
import com.carvalho.api.domain.repository.IUserRepository;
import com.carvalho.api.domain.service.UserService;

import lombok.AllArgsConstructor;

/**
 * manoel.carvalho
 *
 */

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
	
	private IUserRepository userRepository;
	private UserService userService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Users createUsers(@Valid @RequestBody Users user) {
		return userService.createUser(user);
	}
	
	@GetMapping
	public List<Users> readUsers() {
		return userService.searchUsers();
	}
	
	@GetMapping("/{usersId}")
	public ResponseEntity<Users> readUsersId(@PathVariable Long usersId) {
		Optional<Users> user = userRepository.findById(usersId);
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<Users> updateUser(@Valid @PathVariable Long userId, @RequestBody Users user) {
		if (!userRepository.existsById(userId)) {
			return ResponseEntity.notFound().build();
		}
		user.setId(userId);
		user = userService.createUser(user);
		
		return ResponseEntity.ok(user);
		
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteId(@PathVariable Long userId) {
		if (!userRepository.existsById(userId)) {
			return ResponseEntity.notFound().build();
		}
		userService.deleteClient(userId);
		return ResponseEntity.noContent().build();
		
	}
	

}
