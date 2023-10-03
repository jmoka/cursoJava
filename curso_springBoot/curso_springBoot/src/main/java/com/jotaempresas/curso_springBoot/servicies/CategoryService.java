package com.jotaempresas.curso_springBoot.servicies;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotaempresas.curso_springBoot.entites.Category;
import com.jotaempresas.curso_springBoot.repositories.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	@Transactional
	public List<Category> findAll() {
		return repository.findAll();

	}

	@Transactional
	public Category findById(Long id) {
		Category Category = repository.findById(id).orElse(null);
		return Category;
	}

}
