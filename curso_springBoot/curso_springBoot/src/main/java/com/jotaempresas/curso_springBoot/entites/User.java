package com.jotaempresas.curso_springBoot.entites;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user") // renomear o nome 
public class User implements Serializable {
	
	// cria o serializable  -  para que o objeto posso trafegar na rede , pois e transformado em byts
	private static final long serialVersionUID = 1L;
	
	
	
	
	// criar ao atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	
// criar as associação
	// onde um usuario ( user) tem muitos pedidos(order) 
	// e como e 1 para muitos , tem que ser veitos e instanciado uma lista
	// criar a anotação para o mapeamento
	
	@OneToMany (mappedBy = "client") //(Um para muitos) e informar o nome do atributo que esta do outro lado no caso order
	private List<Order> order = new ArrayList<>() ; // dessa forma instanciamos a lista e associamos com os pedidos
	
	
// OBS : CRIAR O MÉTODO GET SOMENTE  -  POIS EM UMA COLEÇÃO TEMOS QUE APENAS CONSULTAR E NÃO TROCAR , ENTÃO NÃO SE COLOCA SET
	
	
// criar os construtores
	
	public User (){
		super();
	}


public User(Long id, String name, String email, String phone, String password) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.password = password;
}

// criar os get e set
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


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public List<Order> getOrder() {
	return order;
}
	


// criar os hashcode para comparar os objetos por id
@Override
public int hashCode() {
	return Objects.hash(id);
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(id, other.id);
}

// cria o toString para apresentar o objeto
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password
			+ "]";
}



	
// OBS tem que ser criado Recurso basico , baseado na cclasse user
}
