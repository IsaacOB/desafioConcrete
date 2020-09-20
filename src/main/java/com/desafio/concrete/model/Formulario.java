package com.desafio.concrete.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class Formulario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String name;
	private String email;
	private String password;

	@OneToMany(mappedBy = "formulario", cascade = CascadeType.PERSIST)
	private List<Phone> phones;

	@CreatedDate
	@Column(insertable = true, updatable = false)
	private LocalDateTime created;

	@LastModifiedDate
	@Column(insertable = true, updatable = true)
	private LocalDateTime modified;

	@Column(name = "last_login", insertable = true, updatable = true)
	private Date lastLogin;

	@Column(insertable = true, updatable = false)
	private String token;

	public Formulario() {
	}

	public Formulario(String name, String email, String password, List<Phone> phones) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}

	@PrePersist
	private void onCreate() {
		modified = created = LocalDateTime.now();
		lastLogin = new Date();
		token = UUID.randomUUID().toString();
	}

	@PreUpdate
	private void onUpdate() {
		modified = LocalDateTime.now();
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date last_login) {
		this.lastLogin = last_login;
	}

	public String getToken() {
		return token;
	}

}
