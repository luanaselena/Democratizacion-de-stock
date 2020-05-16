package com.unla.Grupo30022020.converters;

import org.springframework.stereotype.Component;
import com.unla.Grupo30022020.entities.Venta;
import com.unla.Grupo30022020.models.VentaModel;

@Component("ventaConverter")
public class VentaConverter {

	public VentaModel entityToModel(Venta venta) {
		return new VentaModel(venta.getId(), venta.getNroVenta(), venta.getVendedorEncargado(), venta.getCliente(),
				venta.getFecha(), venta.getHora(), venta.getPrecioTotal());
	}

	public Venta modelToEntity(VentaModel ventaModel) {
		return new Venta(ventaModel.getId(), ventaModel.getNumVenta(), ventaModel.getFecha(), ventaModel.getHora(),
				ventaModel.getPrecioTotal(), ventaModel.getCliente(), ventaModel.getVendedorEncargado());
	}

}
