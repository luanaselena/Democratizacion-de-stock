package com.unla.Grupo30022020.services.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo30022020.converters.PedidoConverter;
import com.unla.Grupo30022020.converters.ProductoConverter;
import com.unla.Grupo30022020.entities.Pedido;
import com.unla.Grupo30022020.entities.Producto;
import com.unla.Grupo30022020.models.PedidoModel;
import com.unla.Grupo30022020.models.ProductoRankingModel;
import com.unla.Grupo30022020.repositories.IPedidoRepository;
import com.unla.Grupo30022020.services.IPedidoService;
import com.unla.Grupo30022020.services.IProductoService;

@Service("pedidoService")
public class PedidoService implements IPedidoService{
	
	@Autowired
	@Qualifier("pedidoRepository")
	private IPedidoRepository pedidoRepository;
	
	@Autowired
	@Qualifier("pedidoConverter")
	private PedidoConverter pedidoConverter;
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	 @Autowired
	 @Qualifier("productoService")
	 private IProductoService productoService;
	
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
	  @Override
	  public List<ProductoRankingModel> rankingproductosvendidos(){
		  
		  //producto auxiliar que se usara para agregarlo a la lista
		  ProductoRankingModel prodAuxiliar = new ProductoRankingModel();
		  
		  //la lista que se retornara al final
		  List<ProductoRankingModel> productosList = new ArrayList<>();
		  
		  //todos los productos que se tienen
		  List<Producto> productos = productoService.getAll();
		  
		  //lista de pedidos a utilizar luego
		  List<Pedido> auxiliar = new ArrayList<>();
		  
		  int cantidadAux=0;
		  
		  //itero por todos los productos para traer los pedidos en los que se encuentra
		  //y sumar todas las cantidades y guardarlas en un ProductoRankingModel
		  for(Producto p : productos) {
			  
			  prodAuxiliar = new ProductoRankingModel();
			  
			  cantidadAux=0;
			  
			  //traigo todos los pedidos con este producto
			  auxiliar = this.pedidosPorProducto(p);
			  
			  //sumo todas las cantidades
			  for(Pedido ped : auxiliar) {
				 cantidadAux+=ped.getCantidad();
			  }
			  //seteo los valores de el producto
			  prodAuxiliar.setProducto(productoConverter.entityToModel(p));
			  
			  prodAuxiliar.setCantidad(cantidadAux);
			  
			  //lo agrego a la lista
			  productosList.add(prodAuxiliar);
			  
		  }
		  
		  //ordeno la lista de mayor a menor
		  Collections.sort(productosList,new Comparator<ProductoRankingModel>()
          {
              public int compare(ProductoRankingModel o1,
            		  ProductoRankingModel o2)
              {
                  if (o1.getCantidad() == o2.getCantidad())
                  {
                      return 0;
                  }
                  else if (o1.getCantidad() >
                               o2.getCantidad())
                  {
                      return -1;
                  }
                  return 1;
              }});
		  
		  //la regreso
		  return productosList;
		  
		  
	  }
	  
	 //metodo para traer todos los pedidos con un determinado producto
	 public List<Pedido> pedidosPorProducto(Producto p){
		 List<Pedido> pedidos = this.getAll();
		 
		 List<Pedido> auxiliar = new ArrayList<>();
		 
		 for(Pedido ped: pedidos) {
			 if(ped.getProducto().getId()==p.getId()) {
				 auxiliar.add(ped);
			 }
		 }
		 
		 return auxiliar;
	 }
}
