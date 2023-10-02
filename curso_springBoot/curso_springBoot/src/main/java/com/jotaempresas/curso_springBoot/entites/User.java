package com.jotaempresas.curso_springBoot.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	/*
	 
	 Neste exemplo:

@OneToMany(mappedBy = "client", fetch = FetchType.EAGER) define que a associação 
entre User e Order é do tipo "um para muitos" (@OneToMany) e que o campo orders 
deve ser carregado imediatamente (fetch = FetchType.EAGER) quando um User for carregado do banco de dados.
@JsonIgnore é usado para instruir o Jackson a não incluir o campo orders ao serializar um objeto 
User em JSON. Isso evita problemas de recursão infinita ou resposta JSON excessivamente grande.
	
	
	*/
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private List<Order> order = new ArrayList<>();

	public User() {
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
