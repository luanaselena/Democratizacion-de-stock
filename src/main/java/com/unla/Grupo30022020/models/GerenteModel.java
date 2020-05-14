package com.unla.Grupo30022020.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class GerenteModel extends EmpleadoModel{
	
	public GerenteModel() {
		
	}

	public GerenteModel(long id, String nombre, String apellido, LocalDate fechaDeNacimiento, long dni,
			LocalTime horasPorJornada, float sueldoBasico) {
		super(id, nombre, apellido, fechaDeNacimiento, dni, horasPorJornada, sueldoBasico);
	}
	
	
	
}
