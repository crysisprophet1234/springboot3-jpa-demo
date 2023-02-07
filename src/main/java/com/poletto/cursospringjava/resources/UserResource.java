package com.poletto.cursospringjava.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poletto.cursospringjava.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User usr = new User(1L, "Maria", "maria@gmail.com", "555199891", "coxinha123");
		return ResponseEntity.ok().body(usr);
	}

}
