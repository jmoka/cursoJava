package com.jotaempresas.curso_springBoot.servicies;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotaempresas.curso_springBoot.entites.Product;
import com.jotaempresas.curso_springBoot.repositories.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Transactional
	public List<Product> findAll() {
		return repository.findAll();

	}

	@Transactional
	public Product findById(Long id) {
		Product Product = repository.findById(id).orElse(null);
		return Product;
	}

}
