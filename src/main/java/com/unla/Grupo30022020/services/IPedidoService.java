package com.unla.Grupo30022020.services;
import java.util.List;
import com.unla.Grupo30022020.entities.Pedido;
import com.unla.Grupo30022020.entities.Producto;
import com.unla.Grupo30022020.models.PedidoModel;
import com.unla.Grupo30022020.models.ProductoRankingModel;
public interface IPedidoService {
	
	 public List<Pedido> getAll();
	   
	 public PedidoModel findById(long id);
	    public PedidoModel findByCantidad(int cantidad);
	    public PedidoModel findByProducto (Producto producto);
	    public PedidoModel insert(PedidoModel pedidoModel);
	    public PedidoModel update(PedidoModel pedidoModel);
	    public boolean remove(long id);
	    public List<ProductoRankingModel> rankingproductosvendidos();
		

}
