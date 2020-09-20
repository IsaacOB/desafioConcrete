package com.desafio.concrete.exception;

public class ExistingEmailException extends Exception {

	private static final long serialVersionUID = 1L;

	public ExistingEmailException(String message) {
		super(message);
	}
}
