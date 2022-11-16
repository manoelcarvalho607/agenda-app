/**
 * 
 */
package com.carvalho.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carvalho.api.domain.model.Clients;
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
	public Users createUsers(@RequestBody Users user) {
		return userService.createUser(user);
	}
	
	@GetMapping
	public List<Users> readUsers() {
		return userRepository.findAll();
	}

}
