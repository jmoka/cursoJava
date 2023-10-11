package com.jotaempresas.curso_springBoot.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jotaempresas.curso_springBoot.entites.User;
import com.jotaempresas.curso_springBoot.servicies.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();

		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*
	 * 
	 * dessa forma retorna o codigo 200, mais o ideal e o retorno do código 201 para isso iremos usar de outra forma
	
	@PostMapping
	public ResponseEntity<User> insert (@RequestBody User objUser ){
		objUser = service.insert(objUser);
		return ResponseEntity.created(loca)
	}
 */
	
	@PostMapping
	public ResponseEntity<User> insert (@RequestBody User objUser ){
		objUser = service.insert(objUser);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objUser.getId()).toUri();
		return ResponseEntity.created(uri).body(objUser);
}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User>update(@PathVariable Long id, @RequestBody User objUser){
		objUser = service.update(id, objUser);
		return ResponseEntity.ok().body(objUser);
	}

}