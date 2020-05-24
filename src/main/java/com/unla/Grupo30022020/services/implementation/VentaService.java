package com.unla.Grupo30022020.services.implementation;

import java.util.List;

import com.unla.Grupo30022020.converters.ProductoConverter;
import com.unla.Grupo30022020.converters.SucursalConverter;
import com.unla.Grupo30022020.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo30022020.converters.VentaConverter;
import com.unla.Grupo30022020.entities.Venta;
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
	
	@Autowired
	@Qualifier("pedidoService")
	private PedidoService pedidoService;
	
	@Autowired
	@Qualifier("vendedorService")
	private VendedorService vendedorService;
	
	@Autowired
	@Qualifier("clienteService")
	private ClienteService clienteService;

	@Override
	public List<Venta> getAll() {

		return ventaRepository.findAll();
	}

	@Override
	public VentaModel findById(long id) {

		return ventaConverter.entityToModel(ventaRepository.findById(id));
	}


	@Override
	public VentaModel insert(VentaModel ventaModel) {
		
		ventaModel.setVendedorEncargado(vendedorService.findById(ventaModel.getVendedorEncargado().getId()));
		ventaModel.setCliente(clienteService.findById(ventaModel.getCliente().getId()));
		
		Venta venta = ventaRepository.save(ventaConverter.modelToEntity(ventaModel));
		return ventaConverter.entityToModel(venta);
	}

	@Override
	public VentaModel update(VentaModel ventaModel) {
		
		ventaModel.setVendedorEncargado(vendedorService.findById(ventaModel.getVendedorEncargado().getId()));
		ventaModel.setCliente(clienteService.findById(ventaModel.getCliente().getId()));
		
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

	@Override
	public void generarPedidoConStockPropio(VentaModel ventaModel, ProductoModel productoModel, SucursalModel sucursalModel, int cantidad) {
	
		sucursalService.restarLotes(sucursalModel.getId(), productoModel.getId(), cantidad);

		float plus = ((productoModel.getPrecioUnitario() * 5) / 100) * cantidad;
		VendedorModel vendedorModel = vendedorService.findById(ventaModel.getVendedorEncargado().getId());
		vendedorModel.setPlus(ventaModel.getVendedorEncargado().getPlus() + plus);
		vendedorService.update(vendedorModel);

		PedidoModel pedido = new PedidoModel(cantidad,productoModel);
		
		/*
		 * Hay que modificar el precio total de la venta sumando el precio de este pedido
		 * 
		 */
		
		pedidoService.insert(pedido);
		
		ventaModel.getPedidos().add(pedido);
		ventaModel.setVendedorEncargado(vendedorModel);
		
		this.update(ventaModel);
		
	}
	
	//-----------------------------Proceso de eliminacion de un pedido en la lista
    public VentaModel EliminarPedido(long idVenta,long idPedido) {
    	
         VentaModel venta = this.findById(idVenta);
    	
         for (PedidoModel p : venta.getPedidos() ) {
        	    if(p.getId() == idPedido) {
        	    	venta.getPedidos().remove(p);
        	    	//Se cambia el estado de aceptado del pedido
        	    	p.setAceptado(true);
        	    	pedidoService.update(p);
        	    }
        	}
         
    	return venta;
    }
}
