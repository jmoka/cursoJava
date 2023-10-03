package com.jotaempresas.curso_springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jotaempresas.curso_springBoot.entites.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
