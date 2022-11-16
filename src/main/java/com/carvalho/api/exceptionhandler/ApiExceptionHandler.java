/**
 * 
 */
package com.carvalho.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.carvalho.api.domain.exception.DomainException;

/**
 * manoel.carvalho
 *
 */
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	Problem problem = new Problem();
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Problem.Campo> campos = new ArrayList<>();
		
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) error).getField();
			String mensagem = error.getDefaultMessage();
			
			campos.add(new Problem.Campo(nome, mensagem));
		}
		
		
		
		problem.setStatus(status.value());
		problem.setDataHora(LocalDateTime.now());
		problem.setTitulo("Um ou mais campos estao inválidos. faça o preechimento correto e tente novamente.");
		problem.setCampos(campos);
		
		return handleExceptionInternal(ex, problem, headers, status, request);
	}
	
	@ExceptionHandler(DomainException.class)
	public ResponseEntity<Object> handleBusiness(DomainException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		
		problem.setStatus(status.value());
		problem.setDataHora(LocalDateTime.now());
		problem.setTitulo(ex.getMessage());
	
		
		
		return handleExceptionInternal(ex,problem, new HttpHeaders(),status,request);
	}
}
