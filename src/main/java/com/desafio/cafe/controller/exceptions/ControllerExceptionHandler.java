package com.desafio.cafe.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.desafio.cafe.servicer.exceptions.ControllerNotFoundException;
import com.desafio.cafe.servicer.exceptions.DatabaseException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ControllerNotFoundException.class)
	public ResponseEntity<StandardError> controllerNotFoud(ControllerNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
		String error = "Database error: Colaborador não pode ser deletado pois há opções de café inseridas";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
