package com.jotaempresas.curso_springBoot.servicies.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Objeto não Encontrado com id "+ id);
	}

}
