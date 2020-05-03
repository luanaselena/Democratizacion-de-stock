package com.unla.Grupo30022020.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Gerente extends Empleado{
	
	
	public Gerente() {
		
	}

	public Gerente(String nombre, String apellido, Date fechaDeNacimiento, long dni, LocalTime horasPorJornada,
			float sueldoBasico) {
		super(nombre, apellido, fechaDeNacimiento, dni, horasPorJornada, sueldoBasico);
	}
	
	
	
	
}
