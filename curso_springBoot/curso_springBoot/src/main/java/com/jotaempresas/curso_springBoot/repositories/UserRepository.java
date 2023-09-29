package com.jotaempresas.curso_springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jotaempresas.curso_springBoot.entites.User;

// responsavel pelas operações com repositorio para user
// essa anotação é opcional , devido userRepository esta erdando de JpaRepository que implicitamente ja tem a anotação
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	//void saveAll(List<User> asList); // extendendo o JPA passando o tipo da entidade e a chave 

	
	
}
