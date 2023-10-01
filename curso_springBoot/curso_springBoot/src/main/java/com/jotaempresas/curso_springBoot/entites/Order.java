package com.jotaempresas.curso_springBoot.entites;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // informa que será uma tabela do banco de dados
@Table(name = "tb_order") // renomear o nome da tabela
public class Order  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id  // informa a chave primaria id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	
	// criando as associações
	// onde um pedido ( order) tem um usuario 
	
	
	@ManyToOne  // ( Muitos para um )
	@JoinColumn (name = "client_id") // informa o nome da chave estrangeira , aqui ser aarmazenado o id do cliente
	private User client; // vem ser o atributo de associação entre a classe user
	
	public Order () {
		super();
	}

	public Order(Long id, Instant moment, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", moment=" + moment + ", client=" + client + "]";
	}
	

}
