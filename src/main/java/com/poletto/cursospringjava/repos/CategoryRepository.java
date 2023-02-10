package com.poletto.cursospringjava.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poletto.cursospringjava.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
