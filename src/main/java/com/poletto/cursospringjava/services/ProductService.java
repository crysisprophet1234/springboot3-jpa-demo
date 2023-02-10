package com.poletto.cursospringjava.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poletto.cursospringjava.entities.Product;
import com.poletto.cursospringjava.repos.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository categoryRepository;
	
	public List<Product> findAll() {
		return categoryRepository.findAll();
	}

	public Product findById(Long id) {
		
		Optional<Product> obj = categoryRepository.findById(id);
		return obj.orElseThrow(() -> new NoSuchElementException("Usuário não encontrado!"));	
		
	}
	
}
