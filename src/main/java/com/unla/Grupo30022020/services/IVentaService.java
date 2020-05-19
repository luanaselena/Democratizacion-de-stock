package com.unla.Grupo30022020.services;

import java.util.List;

import com.unla.Grupo30022020.entities.Venta;
import com.unla.Grupo30022020.models.VentaModel;

public interface IVentaService {

	public List<Venta> getAll();

	public VentaModel findById(long id);
	
	public VentaModel findByNroVenta(int nroVenta);

	public VentaModel insert(VentaModel ventaModel);

	public VentaModel update(VentaModel ventaModel);

	public boolean remove(long id);

}
