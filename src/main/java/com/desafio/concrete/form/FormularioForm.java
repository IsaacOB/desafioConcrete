package com.desafio.concrete.form;

import java.util.List;

import com.desafio.concrete.model.Formulario;
import com.desafio.concrete.model.Phone;
import com.desafio.concrete.repository.FormularioRepository;

public class FormularioForm {

	private String name;
	private String email;
	private String password;
	private List<Phone> phones;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Formulario convert(FormularioRepository formularioRepository) {
		return new Formulario(name, email, password, phones);
	}
}
