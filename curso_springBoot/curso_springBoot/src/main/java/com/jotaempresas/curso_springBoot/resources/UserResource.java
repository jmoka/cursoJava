package com.jotaempresas.curso_springBoot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jotaempresas.curso_springBoot.entites.User;
import com.jotaempresas.curso_springBoot.servicies.UserService;

// temos que informar que a classe é um recurso e é controlado por um contolador controllers

@RestController 
@RequestMapping (value = "/users") // informar o nome, colocar o caminho do meu recurso
public class UserResource {
	
	@Autowired
	private UserService service; // dependencia para o service
	
	// metodo que será o end-point de acesso aos usuarios
	
	@GetMapping   // método que responde ao tipo get do http , tem que ter essa anotação 
	public ResponseEntity<List<User>> findAll(){ // a resposta será o nome da classe e dar um nome para o método
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	
	// esse é modelo de um controlador que responde no caminho /users
	
	
	

}
