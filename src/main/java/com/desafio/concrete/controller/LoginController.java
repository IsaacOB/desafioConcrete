package com.desafio.concrete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.concrete.exception.EmailNotFound;
import com.desafio.concrete.exception.PasswordNotFound;
import com.desafio.concrete.form.LoginForm;
import com.desafio.concrete.model.Formulario;
import com.desafio.concrete.repository.FormularioRepository;
import com.desafio.concrete.repository.PhoneRepository;

@RestController
@RequestMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

	@Autowired
	FormularioRepository formularioRepository;

	@Autowired
	PhoneRepository phoneRepository;

	@PostMapping
	public ResponseEntity<Formulario> login(@RequestBody LoginForm loginForm) throws EmailNotFound, PasswordNotFound {

		verifyEmail(loginForm.getEmail());
		Formulario verifyPassword = verifyPassword(loginForm.getPassword());

		return ResponseEntity.ok().body(verifyPassword);

	}

	private void verifyEmail(String email) throws EmailNotFound {

		Formulario findByEmail = formularioRepository.findByEmail(email);

		if (findByEmail == null) {
			throw new EmailNotFound("Usuário e/ou senha inválidos");
		}
	}

	private Formulario verifyPassword(String password) throws PasswordNotFound {

		Formulario findByPassword = formularioRepository.findByPassword(password);

		if (findByPassword == null) {
			throw new PasswordNotFound("Usuário e/ou senha inválidos");
		}

		return findByPassword;

	}

}
