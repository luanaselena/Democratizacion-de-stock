package com.unla.Grupo30022020.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class VendedorModel extends EmpleadoModel{
private float plus;
	
	public VendedorModel() {
		
	}

	public VendedorModel(long id, String nombre, String apellido, LocalDate fechaDeNacimiento, long dni,
			LocalTime horasPorJornada, float sueldoBasico, float plus) {
		super(id, nombre, apellido, fechaDeNacimiento, dni, horasPorJornada, sueldoBasico);
		this.plus = plus;
	}

	public float getPlus() {
		return plus;
	}

	public void setPlus(float plus) {
		this.plus = plus;
	}
}
