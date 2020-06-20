package com.unla.Grupo30022020.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo30022020.entities.Lote;
import com.unla.Grupo30022020.entities.Pedido;
import com.unla.Grupo30022020.entities.Venta;
import com.unla.Grupo30022020.models.LoteModel;
import com.unla.Grupo30022020.models.PedidoModel;
import com.unla.Grupo30022020.models.VentaModel;

@Component("ventaConverter")
public class VentaConverter {

	@Autowired
	@Qualifier("vendedorConverter")
	private VendedorConverter vendedorConverter;
	
	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;
	
	@Autowired
	@Qualifier("pedidoConverter")
	private PedidoConverter pedidoConverter;
	
	public VentaModel entityToModel(Venta venta) {
		return new VentaModel(venta.getId(), vendedorConverter.entityToModel(venta.getVendedorEncargado()), clienteConverter.entityToModel( venta.getCliente()),
				venta.getFecha(), venta.getHora(), venta.getPrecioTotal(),this.PedidosEntityToModel(venta.getPedidos()));
	}

	public Venta modelToEntity(VentaModel ventaModel) {
		return new Venta(ventaModel.getId(), ventaModel.getFecha(), ventaModel.getHora(),
				ventaModel.getPrecioTotal(), clienteConverter.modelToEntity( ventaModel.getCliente()),
				vendedorConverter.modelToEntity(ventaModel.getVendedorEncargado()),this.PedidosModelToEntity(ventaModel.getPedidos()));
	}
	
//Conversiones de la lista de pedidos--------------------------------------------------
    
    public Set<PedidoModel> PedidosEntityToModel(Set<Pedido> pedidos){
    	Set<PedidoModel> listaAuxiliar = new HashSet<>();
    	PedidoModel auxiliar;
    	for(Pedido p : pedidos) {
    		
    		auxiliar = pedidoConverter.entityToModel(p);
    		listaAuxiliar.add(auxiliar);
    	}
    	
    	return listaAuxiliar;
    	
    }
    
    public Set<Pedido> PedidosModelToEntity(Set<PedidoModel> pedidos){
    	Set<Pedido> listaAuxiliar = new HashSet<>();
    	Pedido auxiliar;
    	for(PedidoModel p : pedidos) {
    		
    		auxiliar = pedidoConverter.modelToEntity(p);
    		listaAuxiliar.add(auxiliar);
    	}
    	
    	return listaAuxiliar;
    	
    }

}
