package com.unla.Grupo30022020.services;

import java.util.List;

import com.unla.Grupo30022020.entities.Gerente;
import com.unla.Grupo30022020.models.GerenteModel;

public interface IGerenteService {
	public List<Gerente> getAll();
    public GerenteModel findById(long id);
    public GerenteModel findByDni(long dni);
    public GerenteModel insert(GerenteModel gerenteModel);
    public GerenteModel update(GerenteModel gerenteModel);
    public boolean remove(long id);
}
