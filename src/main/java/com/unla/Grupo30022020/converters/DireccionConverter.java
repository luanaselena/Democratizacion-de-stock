package com.unla.Grupo30022020.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo30022020.entities.Direccion;
import com.unla.Grupo30022020.models.DireccionModel;

@Component("direccionConverter")
public class DireccionConverter {

	public DireccionModel entityToModel(Direccion direccion) {
		return new DireccionModel(direccion.getId(), direccion.getCiudad(), direccion.getCalle(), direccion.getNumero(), direccion.getLatitud(),direccion.getLongitud());
	}

	public Direccion modelToEntity(DireccionModel direccionModel) {
		return new Direccion(direccionModel.getId(), direccionModel.getCiudad(), direccionModel.getCalle(), direccionModel.getNumero(), direccionModel.getLatitud(),direccionModel.getLongitud());
	}
}