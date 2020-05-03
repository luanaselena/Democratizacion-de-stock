package com.unla.Grupo30022020.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo30022020.entities.Pedido;
import com.unla.Grupo30022020.models.PedidoModel;

@Component("pedidoConverter")
public class PedidoConverter {

	public PedidoModel enityToModel(Pedido pedido) {
		
		return new PedidoModel(pedido.getIdPedido(), pedido.getCantidad(), pedido.getProducto());
	}
	
	public Pedido modelToEnity (PedidoModel pedidoModel) {
		
		return new Pedido(pedidoModel.getId(), pedidoModel.getCantidad(), pedidoModel.getProducto());
	}
	
	
}
