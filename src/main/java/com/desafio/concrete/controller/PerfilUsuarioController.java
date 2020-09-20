package com.desafio.concrete.controller;

import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafio.concrete.exception.InvalidSession;
import com.desafio.concrete.exception.NotAutorize;
import com.desafio.concrete.exception.UserNotFound;
import com.desafio.concrete.model.Formulario;
import com.desafio.concrete.repository.FormularioRepository;

@Controller
@RequestMapping("/perfil")
public class PerfilUsuarioController {

	private static final int MINUTE = 60000;
	@Autowired
	FormularioRepository formularioRepository;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Formulario>> perfilUsuario(@PathVariable UUID id,
			@RequestHeader Map<String, String> requestHeaders) throws NotAutorize, UserNotFound, InvalidSession {

		String token = requestHeaders.get("token");

		if (StringUtils.isEmpty(token)) {
			throw new NotAutorize("Não Autorizado");
		}

		Optional<Formulario> formulario = formularioRepository.findById(id);

		if (!formulario.get().getToken().equals(token)) {
			throw new NotAutorize("Não Autorizado");
		}

		comparingTimeLastLogin(formulario.get().getLastLogin());

		return new ResponseEntity<>(formulario, HttpStatus.OK);

	}

	private void comparingTimeLastLogin(Date lastLogin) throws InvalidSession {
		Date now = new Date();

		long difference = (now.getTime() - lastLogin.getTime()) / MINUTE;

		if (difference < 30) {
			throw new InvalidSession("Sessão Inválida");
		}

	}

}
