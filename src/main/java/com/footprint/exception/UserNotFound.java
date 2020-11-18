package com.footprint.exception;

public class UserNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserNotFound(String mensagem) {
		super(mensagem);		
	}

	public UserNotFound(Long id) {
		this(String.format("Não existe um cadastro de usuário com código %d", id));
	}
}