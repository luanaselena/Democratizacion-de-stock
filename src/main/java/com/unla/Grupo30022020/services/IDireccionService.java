package com.unla.Grupo30022020.services;

import java.util.List;

import com.unla.Grupo30022020.entities.Direccion;
import com.unla.Grupo30022020.models.DireccionModel;


public interface IDireccionService {

	public List<Direccion> getAll();
	
	public DireccionModel findById(long id);
	
	public DireccionModel findByCalle(String calle);
	
	public DireccionModel Insert(DireccionModel direccionModel);
	
	public DireccionModel Update(DireccionModel direccionModel);
	
	public boolean remove(long id);
	
}