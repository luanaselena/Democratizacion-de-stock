package com.unla.Grupo30022020.services;

import java.util.List;

import com.unla.Grupo30022020.entities.Vendedor;
import com.unla.Grupo30022020.models.VendedorModel;

public interface IVendedorService {
	
	public List<Vendedor> getAll();
    public VendedorModel findById(long id);
    public VendedorModel findByDni(Long dni);
    public VendedorModel insert(VendedorModel vendedorModel);
    public VendedorModel update(VendedorModel vendedorModel);
    public boolean remove(long id);
    
}
