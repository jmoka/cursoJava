package com.jotaempresas.curso_springBoot.entites;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	

	// provisório , 	@Transient impedir que o java tente interpretar o set
	@Transient
	private Set<Product> products = new HashSet<>(); // instanciada
	
	public Category() {
		super();
	}

	// não se coloca as coleções no construtor , pelo motivo de ja esta sendo inicialidada acima
	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	

	public Set<Product> getProducts() {
		return products;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", products=" +  "]";
	}






	
	

}
