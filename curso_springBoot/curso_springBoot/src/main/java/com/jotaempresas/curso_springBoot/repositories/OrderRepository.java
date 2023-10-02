package com.jotaempresas.curso_springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jotaempresas.curso_springBoot.entites.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
