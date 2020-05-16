package com.unla.Grupo30022020.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Vendedor extends Empleado {
	
	@Column(name = "plus", nullable = true)
	private float plus;
	
	public Vendedor() {
		
	}

	public Vendedor(long id,String nombre, String apellido, LocalDate fechaDeNacimiento, long dni, LocalTime horasPorJornada,
			float sueldoBasico, float plus) {
		super(id,nombre, apellido, fechaDeNacimiento, dni, horasPorJornada, sueldoBasico);
		this.plus = plus;
	}

	public float getPlus() {
		return plus;
	}

	public void setPlus(float plus) {
		this.plus = plus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(plus);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		if (Float.floatToIntBits(plus) != Float.floatToIntBits(other.plus))
			return false;
		return true;
	}
	
	
	
	
}
