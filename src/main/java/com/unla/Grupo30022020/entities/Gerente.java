package com.unla.Grupo30022020.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;

@Entity
public class Gerente extends Empleado{
	
	
	public Gerente() {
		
	}

	public Gerente(long id,String nombre, String apellido, LocalDate fechaDeNacimiento, long dni, LocalTime horasPorJornada,
			float sueldoBasico) {
		super(id,nombre, apellido, fechaDeNacimiento, dni, horasPorJornada, sueldoBasico);
	}
	
	
	
	
}
