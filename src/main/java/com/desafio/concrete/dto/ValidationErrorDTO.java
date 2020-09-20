package com.desafio.concrete.dto;

public class ValidationErrorDTO {

	private String mensagem;

	public ValidationErrorDTO(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

}
