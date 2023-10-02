package com.jotaempresas.curso_springBoot.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotaempresas.curso_springBoot.entites.Order;
import com.jotaempresas.curso_springBoot.repositories.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Transactional
	public List<Order> findAll() {
		return repository.findAll();

	}

	@Transactional
	public Order findById(Long id) {
		Order Order = repository.findById(id).orElse(null);
		return Order;
	}

}
