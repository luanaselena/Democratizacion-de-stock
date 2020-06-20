package com.unla.Grupo30022020.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class GerenteModel extends EmpleadoModel{
	
	public GerenteModel() {
		
	}

	public GerenteModel(long id, String nombre, String apellido, LocalDate fechaDeNacimiento, long dni,
			LocalTime horasPorJornada, float sueldoBasico) {
		super(id, nombre, apellido, fechaDeNacimiento, dni, horasPorJornada, sueldoBasico);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
	
	
}
