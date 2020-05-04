package com.unla.Grupo30022020.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends Persona{
	
	@Column(name = "mail", length = 30, nullable = true)
	private String mail;
	
	public Cliente() {
		
	}

	public Cliente(String nombre, String apellido, Date fechaDeNacimiento, long dni, String mail) {
		super(nombre, apellido, fechaDeNacimiento, dni);
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
}
