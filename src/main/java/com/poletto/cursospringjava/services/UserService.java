package com.poletto.cursospringjava.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poletto.cursospringjava.entities.User;
import com.poletto.cursospringjava.repos.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		
		try {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow();
		} catch (NoSuchElementException e) {
			return new User(0L, "User not found", "n/a", "n/a", "n/a");
		}
		
		
	}
	
}
