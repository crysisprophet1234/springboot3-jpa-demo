package com.poletto.cursospringjava.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poletto.cursospringjava.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
