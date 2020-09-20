package com.desafio.concrete.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.concrete.model.Formulario;

public interface FormularioRepository extends JpaRepository<Formulario, UUID> {

	Formulario findByEmail(String email);

	Formulario findByPassword(String password);
}
