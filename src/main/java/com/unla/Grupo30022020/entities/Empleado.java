package com.unla.Grupo30022020.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Empleado extends Persona {

	@Column(name = "horasPorJornada", nullable = true)
	private LocalTime horasPorJornada;
	
	@Column(name = "sueldoBasico", nullable = true)
	private float sueldoBasico;
	
	public Empleado() {
		
	}

	public Empleado(String nombre, String apellido, LocalDate fechaDeNacimiento, long dni, LocalTime horasPorJornada,
			float sueldoBasico) {
		super(nombre, apellido, fechaDeNacimiento, dni);
		this.horasPorJornada = horasPorJornada;
		this.sueldoBasico = sueldoBasico;
	}

	public LocalTime getHorasPorJornada() {
		return horasPorJornada;
	}

	public void setHorasPorJornada(LocalTime horasPorJornada) {
		this.horasPorJornada = horasPorJornada;
	}

	public float getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(float sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	
	
}
