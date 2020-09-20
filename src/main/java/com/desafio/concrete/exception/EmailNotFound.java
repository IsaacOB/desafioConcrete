package com.desafio.concrete.exception;

public class EmailNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	public EmailNotFound(String message) {
		super(message);
	}
}