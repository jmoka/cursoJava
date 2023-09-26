package com.jotaempresas.curso_springBoot.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jotaempresas.curso_springBoot.entites.User;

// temos que informar que a classe é um recurso e é controlado por um contolador controllers

@RestController 
@RequestMapping (value = "/users") // informar o nome, colocar o caminho do meu recurso
public class UserResource {
	
	// metodo que será o end-point de acesso aos usuarios
	
	@GetMapping   // método que responde ao tipo get do http , tem que ter essa anotação 
	public ResponseEntity<User> findAll(){ // a resposta será o nome da classe e dar um nome para o método
		User u = new User(1L, "maria", "maria@gmmail", "444444", "3333333333");
		
		return ResponseEntity.ok().body(u);
		
	}
	
	
	// esse é modelo de um controlador que responde no caminho /users
	
	
	

}
