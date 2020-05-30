package com.unla.Grupo30022020.models;

import java.time.LocalDate;
import java.time.LocalTime;

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
		VendedorModel other = (VendedorModel) obj;
		if (Float.floatToIntBits(plus) != Float.floatToIntBits(other.plus))
			return false;
		return true;
	}
	
	
}
