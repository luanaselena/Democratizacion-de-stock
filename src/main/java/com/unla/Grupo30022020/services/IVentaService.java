package com.unla.Grupo30022020.services;

import java.util.List;

import com.unla.Grupo30022020.entities.Venta;
import com.unla.Grupo30022020.models.ProductoModel;
import com.unla.Grupo30022020.models.SucursalModel;
import com.unla.Grupo30022020.models.VendedorModel;
import com.unla.Grupo30022020.models.VentaModel;

public interface IVentaService {

	public List<Venta> getAll();

	public VentaModel findById(long id);

	public VentaModel insert(VentaModel ventaModel);

	public VentaModel update(VentaModel ventaModel);

	public boolean remove(long id);

	public void generarPedidoConStockPropio(VentaModel ventaModel, ProductoModel productoModel, SucursalModel sucursalModel, int cantidad);
	
	public VentaModel EliminarPedido(long idVenta,long idPedido);

}
