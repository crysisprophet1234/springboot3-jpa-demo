package com.poletto.cursospringjava.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.poletto.cursospringjava.entities.User;
import com.poletto.cursospringjava.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired 
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {
		user = service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
		user = service.update(user, id);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(value = "/login")
	public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
		
		Optional<User> optUser = Optional.ofNullable(service.findByName(username));
		
		if (optUser.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
		}
		
		User user = optUser.get();
		boolean valid = service.encoder.matches(password, user.getPassword());
		
		HttpStatus status = valid ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		String msg = valid ? "Username and password matches" : "Username and password doesnt matches";
		
		return ResponseEntity.status(status).body(msg);
		
	}
	
}
