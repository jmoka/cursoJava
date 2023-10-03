package com.jotaempresas.curso_springBoot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jotaempresas.curso_springBoot.entites.Product;
import com.jotaempresas.curso_springBoot.servicies.ProductService;


@RestController 
@RequestMapping ("/products") 
public class ProductResource {
	
	@Autowired
	private ProductService orderService; 	
	
	@GetMapping   
	public ResponseEntity<List<Product>> findAll(){ 
		List<Product> list = orderService.findAll();		
		return ResponseEntity.ok().body(list);		
	};
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = orderService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

	

}
