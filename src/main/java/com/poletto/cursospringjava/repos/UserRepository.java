package com.poletto.cursospringjava.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poletto.cursospringjava.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
