package com.poletto.cursospringjava.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poletto.cursospringjava.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByName(String name);
	
}
