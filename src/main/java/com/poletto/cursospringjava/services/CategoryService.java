package com.poletto.cursospringjava.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poletto.cursospringjava.entities.Category;
import com.poletto.cursospringjava.repos.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.orElseThrow(() -> new NoSuchElementException("Usuário não encontrado!"));	
		
	}
	
}
