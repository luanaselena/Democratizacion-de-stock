package com.unla.Grupo30022020.services.implementation;

import java.util.List;

import com.unla.Grupo30022020.converters.ProductoConverter;
import com.unla.Grupo30022020.converters.SucursalConverter;
import com.unla.Grupo30022020.entities.Pedido;
import com.unla.Grupo30022020.entities.Sucursal;
import com.unla.Grupo30022020.models.ProductoModel;
import com.unla.Grupo30022020.models.SucursalModel;
import com.unla.Grupo30022020.models.VendedorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo30022020.converters.VentaConverter;
import com.unla.Grupo30022020.entities.Venta;
import com.unla.Grupo30022020.models.VentaModel;
import com.unla.Grupo30022020.repositories.IVentaRepository;
import com.unla.Grupo30022020.services.IVentaService;

@Service("ventaService")
public class VentaService implements IVentaService {

	@Autowired
	@Qualifier("ventaRepository")
	private IVentaRepository ventaRepository;

	@Autowired
	@Qualifier("ventaConverter")
	private VentaConverter ventaConverter;

	@Autowired
	@Qualifier("sucursalConverter")
	private SucursalConverter sucursalConverter;

	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	@Autowired
	@Qualifier("productoService")
	private ProductoService productoService;

	@Autowired
	@Qualifier("sucursalService")
	private SucursalService sucursalService;

	@Override
	public List<Venta> getAll() {

		return ventaRepository.findAll();
	}

	@Override
	public VentaModel findById(long id) {

		return ventaConverter.entityToModel(ventaRepository.findById(id));
	}

	@Override
	public VentaModel findByNroVenta(int nroVenta) {

		return ventaConverter.entityToModel(ventaRepository.findByNroVenta(nroVenta));
	}

	@Override
	public VentaModel insert(VentaModel ventaModel) {
		Venta venta = ventaRepository.save(ventaConverter.modelToEntity(ventaModel));
		return ventaConverter.entityToModel(venta);
	}

	@Override
	public VentaModel update(VentaModel ventaModel) {
		Venta venta = ventaRepository.save(ventaConverter.modelToEntity(ventaModel));
		return ventaConverter.entityToModel(venta);
	}

	@Override
	public boolean remove(long id) {

		try {
			ventaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/*@Override
	public boolean generarPedidoConStockPropio(VentaModel ventaModel, ProductoModel productoModel, SucursalModel sucursalModel, int cantidad) {
		Sucursal sucursal = sucursalConverter.modelToEntity(sucursalModel);
		sucursalService.restarLotes(productoService.findById(productoModel.getId()), cantidad);

		float plus = ((productoModel.getPrecioUnitario() * 5) / 100) * cantidad;

		this.findById(ventaModel.getId()).getVendedorEncargado().setPlus(this.findById(ventaModel.getId()).getVendedorEncargado().getPlus() + plus);

		this.findById(ventaModel.getId()).getVendedorEncargado().setPlus(this.findById(ventaModel.getId()).getVendedorEncargado().getPlus() + plus);
		return this.findById(ventaModel.getId()).getPedidos().add(new Pedido(cantidad, productoConverter.modelToEntity(productoModel)));
	}*/
}
