package com.unla.Grupo30022020.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo30022020.entities.Lote;
import com.unla.Grupo30022020.models.LoteModel;

@Component("loteConverter")
public class LoteConverter {

	public LoteModel entityToModel(Lote lote) {
		return new LoteModel();
	}

	public Lote modelToEntity(LoteModel loteModel) {
		return new Lote();
	}
}