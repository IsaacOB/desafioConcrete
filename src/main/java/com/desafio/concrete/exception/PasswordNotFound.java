package com.desafio.concrete.exception;

public class PasswordNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	public PasswordNotFound(String message) {
		super(message);
	}
}
