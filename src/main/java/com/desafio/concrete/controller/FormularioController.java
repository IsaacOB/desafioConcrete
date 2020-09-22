package com.desafio.concrete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.desafio.concrete.exception.ExistingEmailException;
import com.desafio.concrete.form.FormularioForm;
import com.desafio.concrete.model.Formulario;
import com.desafio.concrete.repository.FormularioRepository;
import com.desafio.concrete.repository.PhoneRepository;

@RestController
@RequestMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class FormularioController {

	@Autowired
	private FormularioRepository formularioRepository;

	@Autowired
	private PhoneRepository phoneRepository;

	@PostMapping
	public ResponseEntity<Formulario> register(@RequestBody FormularioForm formularioForm,
			UriComponentsBuilder uriBuilder) throws ExistingEmailException {

		verifiyEmail(formularioForm.getEmail());

		Formulario formulario = formularioForm.convert(formularioRepository);
		formularioRepository.save(formulario);
		phoneRepository.saveAll(formulario.getPhones());

		return new ResponseEntity<>(formulario, HttpStatus.CREATED);
	}

	private void verifiyEmail(String email) throws ExistingEmailException {

		Formulario findByEmail = formularioRepository.findByEmail(email);
		if (findByEmail == null) {
			return;
		} else {
			throw new ExistingEmailException("E-mail já existente");
		}

	}

}
