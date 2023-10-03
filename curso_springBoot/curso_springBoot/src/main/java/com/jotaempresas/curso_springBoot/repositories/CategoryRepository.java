package com.jotaempresas.curso_springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jotaempresas.curso_springBoot.entites.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
