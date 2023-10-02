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
	 * 
	 * Neste exemplo:
	 * 
	 * @OneToMany(mappedBy = "client", fetch = FetchType.EAGER) define que a
	 * associação entre User e Order é do tipo "um para muitos" (@OneToMany) e que o
	 * campo orders deve ser carregado imediatamente (fetch = FetchType.EAGER)
	 * quando um User for carregado do banco de dados.
	 * 
	 * @JsonIgnore é usado para instruir o Jackson a não incluir o campo orders ao
	 * serializar um objeto User em JSON. Isso evita problemas de recursão infinita
	 * ou resposta JSON excessivamente grande.
	 * 
	 * 
	 * 
	 * @JsonIgnore:
	 * 
	 * IMPORTANTE
	 * 
	 * O @JsonIgnore DEVE SER SEMPRE COLOCADO DO LADO 1 DE UMA ASSOCIAÇÃO DE 1 PARA
	 * MUITOS - PARA QUE SEJA CARREGADO SEMPRE QUE FOR CHAMADO SOMENTE O 1 E NÃO
	 * SUAS ASSOCIAÇÃO
	 * 
	 * SE COLOCAR O @JsonIgnore DO LADDO DO MUITOS , SEMPRE QUE UM OBJETO DO LADO DO
	 * MUITO FOR CHAMADO RETORNA SOMENTE ELE, PORÉM SE CHAMAR O 1 NOVAMENTE ELE IRÁ
	 * CARREGAR TODOS DO MUITO E ISSO NÃO É UMA BOA OPÇÃO , DEPENDENDO DA BASE OU DA
	 * SITUAÇÃO POIS PODE ESTOURAR A MEEMÓRIA SE FOREM MUITOS OBJETOS A SEREM
	 * CARREGADOS.
	 * 
	 * CASO QUEIRA QUE QUANDO CHAMAR O OBJETO SO RETORNE SOMENTE ELE SEM ASSOCIAÇÕES, BASTA COLOCAR @JsonIgnore EM AMBOS OS LADOS
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password
				+ "]";
	}

}
