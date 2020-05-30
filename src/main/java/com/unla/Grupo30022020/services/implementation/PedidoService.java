package com.unla.Grupo30022020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo30022020.converters.PedidoConverter;
import com.unla.Grupo30022020.entities.Pedido;
import com.unla.Grupo30022020.entities.Producto;
import com.unla.Grupo30022020.models.PedidoModel;
import com.unla.Grupo30022020.repositories.IPedidoRepository;
import com.unla.Grupo30022020.services.IPedidoService;

@Service("pedidoService")
public class PedidoService implements IPedidoService{
	
	@Autowired
	@Qualifier("pedidoRepository")
	private IPedidoRepository pedidoRepository;
	
	@Autowired
	@Qualifier("pedidoConverter")
	private PedidoConverter pedidoConverter;
	
	@Override
	public List<Pedido> getAll(){
		return pedidoRepository.findAll();
	}

	@Override
	public PedidoModel findByCantidad(int cantidad) {
		
		return pedidoConverter.entityToModel(pedidoRepository.findByCantidad(cantidad));
	}



	@Override
	public PedidoModel insert(PedidoModel pedidoModel) {
	
		Pedido pedido = pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
		return pedidoConverter.entityToModel(pedido);
	
	}

	 @Override
	    public PedidoModel update(PedidoModel pedidoModel) {

	        Pedido pedido = pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
	        return pedidoConverter.entityToModel(pedido);
	    }

	  @Override
	    public boolean remove(long id){
	        try{
	            pedidoRepository.deleteById(id);
	            return true;
	        }
	        catch(Exception e){
	            return false;
	        }
	    }

	  @Override
	public PedidoModel findById(long id) {
		  return pedidoConverter.entityToModel(pedidoRepository.findById(id));
	  }
	
	  @Override
		public PedidoModel findByProducto(Producto producto) {
			return pedidoConverter.entityToModel(pedidoRepository.findByProducto(producto));
		}
	
	
}
