package com.unla.Grupo30022020.services;

import java.util.List;
import com.unla.Grupo30022020.entities.Lote;
import com.unla.Grupo30022020.entities.Producto;
import com.unla.Grupo30022020.models.LoteModel;


public interface ILoteService {

	public List<Lote> getAll();
	
	public LoteModel findById(long id);
	
	public LoteModel findByProducto(Producto producto);
	
	public LoteModel Insert(LoteModel loteModel);
	
	public LoteModel Update(LoteModel loteModel);
	
	public boolean remove(long id);
	
}