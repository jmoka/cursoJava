package com.jotaempresas.curso_springBoot.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotaempresas.curso_springBoot.entites.User;
import com.jotaempresas.curso_springBoot.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();

	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User objUser) {
		return repository.save(objUser);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

	public User update(Long id, User obj) {
	    User entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
	    updateData(entity, obj);
	    return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
		
	}
}
