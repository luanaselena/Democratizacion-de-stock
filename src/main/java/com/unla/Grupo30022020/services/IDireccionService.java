package com.unla.Grupo30022020.services;

import java.util.List;

import com.unla.Grupo30022020.entities.Direccion;
import com.unla.Grupo30022020.models.DireccionModel;


public interface IDireccionService {

	public List<Direccion> getAll();
	
	public DireccionModel findById(int id);
	
	public DireccionModel findByCalle(String calle);
	
	public DireccionModel insertOrUpdate(DireccionModel direccionModel);
	
	public boolean remove(int id);
	
}