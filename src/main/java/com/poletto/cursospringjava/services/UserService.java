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
		
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new NoSuchElementException("Usuário não encontrado!"));	
		
	}
	
}
