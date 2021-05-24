package com.desafio.cafe.servicer.exceptions;

public class ControllerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ControllerNotFoundException(Object cpf) {
		super("CPF não cadastrado: " + cpf);
	}

}
