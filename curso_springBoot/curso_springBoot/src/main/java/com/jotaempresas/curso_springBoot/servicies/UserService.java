package com.jotaempresas.curso_springBoot.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotaempresas.curso_springBoot.entites.User;
import com.jotaempresas.curso_springBoot.repositories.UserRepository;


// é preciso que seja rejistrado como componente do springbot usando a anotação

@Service
public class UserService {
	
	// dependencia para UserRepository
	
	@Autowired
	UserRepository repository;
	
	public List<User> findAll(){ // repassa a chamada apenas para o repository
		return repository.findAll();
		
	}
	
	public User findById(Long id) {
		Optional <User> obj = repository.findById(id);
		return obj.get();
	}

}
