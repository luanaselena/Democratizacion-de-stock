package com.unla.Grupo30022020.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.unla.Grupo30022020.entities.Venta;
import com.unla.Grupo30022020.models.VentaModel;

@Component("ventaConverter")
public class VentaConverter {

	@Autowired
	@Qualifier("vendedorConverter")
	private VendedorConverter vendedorConverter;
	
	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;
	
	public VentaModel entityToModel(Venta venta) {
		return new VentaModel(venta.getId(), venta.getNroVenta(), vendedorConverter.entityToModel(venta.getVendedorEncargado()), clienteConverter.entityToModel( venta.getCliente()),
				venta.getFecha(), venta.getHora(), venta.getPrecioTotal());
	}

	public Venta modelToEntity(VentaModel ventaModel) {
		return new Venta(ventaModel.getId(), ventaModel.getNumVenta(), ventaModel.getFecha(), ventaModel.getHora(),
				ventaModel.getPrecioTotal(), clienteConverter.modelToEntity( ventaModel.getCliente()),
				vendedorConverter.modelToEntity(ventaModel.getVendedorEncargado()));
	}

}
