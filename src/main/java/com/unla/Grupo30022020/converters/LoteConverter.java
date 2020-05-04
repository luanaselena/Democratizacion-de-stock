package com.unla.Grupo30022020.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo30022020.entities.Lote;
import com.unla.Grupo30022020.models.LoteModel;

@Component("loteConverter")
public class LoteConverter {

	public LoteModel entityToModel(Lote lote) {
		return new LoteModel(lote.getId(), lote.getProducto(), lote.getCantidad(), lote.getCantidadTotal(), lote.getFechaIngreso());
	}

	public Lote modelToEntity(LoteModel loteModel) {
		return new Lote(loteModel.getId(), loteModel.getProducto(), loteModel.getCantidad(), loteModel.getCantidadTotal(), loteModel.getFechaIngreso());
	}
}