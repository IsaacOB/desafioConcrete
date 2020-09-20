package com.desafio.concrete.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.concrete.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
