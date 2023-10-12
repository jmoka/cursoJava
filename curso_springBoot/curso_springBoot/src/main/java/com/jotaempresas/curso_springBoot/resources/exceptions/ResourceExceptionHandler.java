package com.jotaempresas.curso_springBoot.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jotaempresas.curso_springBoot.servicies.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

// interceptar as exceção que ocorrerem para ser tratado
@ControllerAdvice
public class ResourceExceptionHandler {

	// 1 TRATAMENTO ( ResourceNotFoundException )
	// SERVE PARA INTERCEPTAR A REQUIZIÇÃO DE GEROU A EXEÇÃO E CAIR AQUI
	@ExceptionHandler(ResourceNotFoundException.class) // INTERCEPTA AS EXEÇÕES DESSE TIPO ResourceNotFoundException
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
	    String erro = "Recurso não encontrado";
	    HttpStatus status = HttpStatus.NOT_FOUND;
	    StandardError err = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
	    return ResponseEntity.status(status).body(err);
	}

	
}
