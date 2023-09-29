package com.jotaempresas.curso_springBoot.config;

import java.util.Arrays;
import java.util.List;

import com.jotaempresas.curso_springBoot.entites.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jotaempresas.curso_springBoot.entites.User;
import com.jotaempresas.curso_springBoot.repositories.UserRepository;

// para falar que é uma classe de configuração

@Configuration
@Profile("test")
public class TesetConfig implements  CommandLineRunner{
	
	// injeção de dependencia automatica
	// servi para o databas cid , popular o banco de dados
	
	// a classe que salva os dados no banco é a classe repositori
	// nesse caso existe uma injeção de dependencia entre a classe UserRepository
	// e nas boas praticas deve ser feito uma construtor, padrão fectory, método set , isso d forma manual
	// porém iremos usar de forma automatica, no fremework spring
	
	
	 // com essa anatoação do espring resolve o problema de injeção de dependencia, 
	// associa uma estancia de UserRepository aqui!
	
	@Autowired
	private UserRepository userRepository;	
	
	// procimo passo é instanciar alguns objetos e salvar no banco
	// Precisa iniciar a junto com o inicio da aplicação
	// para fazer isso :
	
	// implementar na classe uma interface CommandLineRunner	
	
	
	// todo que for coloca colocado dentro do método, será iniciado com a aplicação
	@Override
	public void run(String... args) throws Exception {	
		// Estanciando os objetos , criando os usuarios
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
				
		// Agora vamos salvar os usuarios , colocar os objetos no banco
		// para passar os objetos para o repositorio e salvar no banco
		// vamos passar uma lista com os objetos
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
	}


}
