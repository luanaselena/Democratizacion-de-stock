package com.unla.Grupo30022020.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo30022020.entities.Pedido;
import com.unla.Grupo30022020.models.PedidoModel;

@Component("pedidoConverter")
public class PedidoConverter {

		
		@Autowired
		@Qualifier("productoConverter")
		private ProductoConverter productoConverter;
		
		public PedidoModel entityToModel(Pedido pedido){
		return new PedidoModel(pedido.getId(), pedido.getCantidad(), productoConverter.entityToModel(pedido.getProducto()));
	}
	
	public Pedido modelToEntity (PedidoModel pedidoModel) {
		
		return new Pedido(pedidoModel.getId(), pedidoModel.getCantidad(), productoConverter.modelToEntity(pedidoModel.getProducto()));
	
	
}
}