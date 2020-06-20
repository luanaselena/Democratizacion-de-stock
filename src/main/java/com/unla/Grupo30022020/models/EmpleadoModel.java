package com.unla.Grupo30022020.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class EmpleadoModel extends PersonaModel{
	
	private LocalTime horasPorJornada;
	private float sueldoBasico;
	
	public EmpleadoModel() {
		
	}

	public EmpleadoModel(long id, String nombre, String apellido, LocalDate fechaDeNacimiento, long dni,
			LocalTime horasPorJornada, float sueldoBasico) {
		super(id, nombre, apellido, fechaDeNacimiento, dni);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((horasPorJornada == null) ? 0 : horasPorJornada.hashCode());
		result = prime * result + Float.floatToIntBits(sueldoBasico);
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
		EmpleadoModel other = (EmpleadoModel) obj;
		if (horasPorJornada == null) {
			if (other.horasPorJornada != null)
				return false;
		} else if (!horasPorJornada.equals(other.horasPorJornada))
			return false;
		if (Float.floatToIntBits(sueldoBasico) != Float.floatToIntBits(other.sueldoBasico))
			return false;
		return true;
	}
	
	
	
}
