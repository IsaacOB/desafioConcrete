package com.desafio.concrete.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Phone {

	@Id
	@GeneratedValue
	private Long id;
	private String number;
	private String ddd;

	@ManyToOne
	private Formulario formulario;

	public Phone() {
		// TODO Auto-generated constructor stub
	}

	public Phone(String number, String ddd) {
		this.number = number;
		this.ddd = ddd;
	}

	public String getNumber() {
		return number;
	}

	public String getDdd() {
		return ddd;
	}

	public Long getId() {
		return id;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

}
