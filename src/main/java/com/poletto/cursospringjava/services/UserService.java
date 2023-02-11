package com.poletto.cursospringjava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.poletto.cursospringjava.entities.User;
import com.poletto.cursospringjava.repos.UserRepository;
import com.poletto.cursospringjava.services.exceptions.DatabaseException;
import com.poletto.cursospringjava.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public final PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {		
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));	
	}
	
	public User findByName(String name) {
		Optional<User> obj = userRepository.findByName(name);
		return obj.orElseThrow(() -> new ResourceNotFoundException(name));
	}

	public User insert(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	public void delete(Long id) {
		try {
		userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update (User user, Long id) {
		try {
		User entity = userRepository.getReferenceById(id);
		updateData(entity, user);
		return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User user) {
		
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
		
	}
	
}
