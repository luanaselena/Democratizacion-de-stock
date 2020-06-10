package com.unla.Grupo30022020.services.implementation;

import com.unla.Grupo30022020.converters.LoteConverter;
import com.unla.Grupo30022020.converters.PedidoConverter;
import com.unla.Grupo30022020.converters.ProductoConverter;
import com.unla.Grupo30022020.converters.SucursalConverter;
import com.unla.Grupo30022020.converters.VentaConverter;
import com.unla.Grupo30022020.entities.Direccion;
import com.unla.Grupo30022020.entities.Lote;
import com.unla.Grupo30022020.entities.Producto;
import com.unla.Grupo30022020.entities.Sucursal;
import com.unla.Grupo30022020.entities.Vendedor;
import com.unla.Grupo30022020.entities.Venta;
import com.unla.Grupo30022020.models.LoteModel;
import com.unla.Grupo30022020.models.PedidoModel;
import com.unla.Grupo30022020.models.ProductoModel;
import com.unla.Grupo30022020.models.SucursalModel;
import com.unla.Grupo30022020.models.VendedorModel;
import com.unla.Grupo30022020.models.VentaModel;
import com.unla.Grupo30022020.repositories.ISucursalRepository;
import com.unla.Grupo30022020.services.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service("sucursalService")
public class SucursalService implements ISucursalService {

    @Autowired
    @Qualifier("sucursalRepository")
    private ISucursalRepository sucursalRepository;

    @Autowired
    @Qualifier("sucursalConverter")
    private SucursalConverter sucursalConverter;
    
    @Autowired
	@Qualifier("direccionService")
	private DireccionService direccionService;
    
    @Autowired
	@Qualifier("gerenteService")
	private GerenteService gerenteService;
    
    @Autowired
   	@Qualifier("loteService")
   	private LoteService loteService;
    
    @Autowired
   	@Qualifier("vendedorService")
   	private VendedorService vendedorService;
    
    @Autowired
   	@Qualifier("ventaService")
   	private VentaService ventaService;
    
    @Autowired
   	@Qualifier("productoService")
   	private ProductoService productoService;
    
    @Autowired
   	@Qualifier("productoConverter")
   	private ProductoConverter productoConverter;

    @Autowired
   	@Qualifier("loteConverter")
   	private LoteConverter loteConverter;
    
    @Autowired
   	@Qualifier("ventaConverter")
   	private VentaConverter ventaConverter;
    
    @Autowired
   	@Qualifier("pedidoConverter")
   	private PedidoConverter pedidoConverter;

    @Override
    public List<Sucursal> getAll(){
        return sucursalRepository.findAll();
    }

    @Override
    public SucursalModel findById(long id){
        return sucursalConverter.entityToModel(sucursalRepository.findById(id));
    }

    @Override
    public SucursalModel findByDireccion(Direccion direccion){
        return sucursalConverter.entityToModel(sucursalRepository.findByDireccion(direccion));
    }

    @Override
    public SucursalModel insert(SucursalModel sucursalModel) {
    	
    	sucursalModel.setGerente(gerenteService.findById(sucursalModel.getGerente().getId()));
    	
        Sucursal sucursal = sucursalRepository.save(sucursalConverter.modelToEntity(sucursalModel));
        return sucursalConverter.entityToModel(sucursal);
    }

    @Override
    public SucursalModel update(SucursalModel sucursalModel) {
    	sucursalModel.setGerente(gerenteService.findById(sucursalModel.getGerente().getId()));
        Sucursal sucursal = sucursalRepository.save(sucursalConverter.modelToEntity(sucursalModel));
        return sucursalConverter.entityToModel(sucursal);
    }

    @Override
    public boolean remove(long id){
        try{
            sucursalRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    @Override
    public float calcularDistancia(Sucursal sucursal1, Sucursal sucursal2) {
    	return (float) Math.sqrt((Math.pow((sucursal1.getDireccion().getLatitud() - sucursal2.getDireccion().getLatitud()), 2) +
				((Math.pow((sucursal1.getDireccion().getLongitud() - sucursal2.getDireccion().getLongitud()), 2)))));
	}
    
    @Override
    public SucursalModel calcularSucursalMasCercana(SucursalModel sucursalModel) {
    	Sucursal sucMasCercana=this.getAll().get(0);
    	Sucursal sucursal = sucursalConverter.modelToEntity(sucursalModel);
		float distancia=this.calcularDistancia(sucursal,this.getAll().get(0));
		
		if(sucursal.getId() == this.getAll().get(0).getId()) {
			distancia=this.calcularDistancia(sucursal,this.getAll().get(1));
			sucMasCercana=this.getAll().get(1);
		}
		
		for(int indice=0; indice<this.getAll().size(); indice++) {
			if(this.calcularDistancia(sucursal,this.getAll().get(indice)) < distancia && (sucursal.getId()!=this.getAll().get(indice).getId()))
			{
				distancia=this.calcularDistancia(sucursal,this.getAll().get(indice));
				sucMasCercana=this.getAll().get(indice);
			}
		}
		SucursalModel sucCercana = sucursalConverter.entityToModel(sucMasCercana);
		return sucCercana;
	}
    
    //-----------------------------Calcular sucursales con un determinado producto disponible
    public List<Sucursal> calcularSucursalesConStockDisponible(Producto producto, int cantidad){
    	List<Sucursal> sucursales = this.getAll();
    	List<Sucursal> sucursalesConStock = new ArrayList<>();
    	
    	//itero en todas las sucursales
    	for(int i=0; i<sucursales.size(); i++) {
    		if(!this.TraerLotesActivosConStock(sucursales.get(i).getId(), producto.getId(), cantidad).isEmpty()) {
    			sucursalesConStock.add(sucursales.get(i));
    		}
    	}    	
    	return sucursalesConStock;
    }
    
    //-----------------------------Proceso de eliminacion de un lote en la lista
    public SucursalModel EliminarLote(long idSucursal,long idLote) {
    	
         SucursalModel sucursal = this.findById(idSucursal);
    	
         LoteModel loteModel = loteService.findById(idLote);
         
         sucursal.getLotes().remove(loteModel);
         
    	return sucursal;
    }
    
    //---------------------Proceso de eliminacion de un Vendedor en la lista
    public SucursalModel EliminarVendedor(long idSucursal,long idVendedor) {
    	
        SucursalModel sucursal = this.findById(idSucursal);
        
        VendedorModel vendedorModel = vendedorService.findById(idVendedor);
        
        sucursal.getVendedores().remove(vendedorModel);
        
        
   	return sucursal;
   }
    
   //----------------------Conseguir todas las ventas de sucursales
    public List<VentaModel>  conseguirVentasSucursal(SucursalModel sucursalModel){
    	List<VentaModel> ventasPorSucursal = new ArrayList<>();
    	
    	for(Venta venta: ventaService.getAll()) {
    		for(VendedorModel vendedor: sucursalModel.getVendedores()) {
    			if(venta.getVendedorEncargado().getId() == vendedor.getId() ) {
    				VentaModel ventaModel = ventaConverter.entityToModel(venta);
    				ventasPorSucursal.add(ventaModel);
    			}
    		}
    	}
    	
    	return ventasPorSucursal;
    }
    
    
   //--------------------------------Traer los lotes que no pertenecen a otras listas----------------------------
    
   public List<Lote> TraerLotesDisponibles(){
	   
	List<Lote> listaAuxiliar= new ArrayList<Lote>(); 
	
   	List<Sucursal> sucursales=this.getAll();
   	
   	boolean flag=true;
   	
   	for(Lote l: loteService.getAll()) {
   		
   		flag=true;
   		
   		//Chequeamos que el lote no este en ninguna lista
   		for(Sucursal s:sucursales) {
   			for(Lote lote :s.getLotes()) {
   				if(lote.getId() == l.getId()) {
   					flag=false;
   				}
   			}
   		}
   		
   		//Si el lote no existe en ninguna lista, esta disponible
   		if(flag==true) {
   			listaAuxiliar.add(l);
   		}
   	}
   	return listaAuxiliar;
   }
   
 //--------------------------------Traer los Vendedores que no pertenecen a otras listas----------------------------
   
   public List<Vendedor> TraerVendedoresDisponibles(){
	   
	List<Vendedor> listaAuxiliar= new ArrayList<Vendedor>(); 
	
   	List<Sucursal> sucursales=this.getAll();
   	
   	boolean flag=true;
   	
	   	for(Vendedor v: vendedorService.getAll()) {
	   		
	   		flag=true;
	   		
	   		//Chequeamos que el vendedor no este en ninguna lista
	   		for(Sucursal s:sucursales) {
	   			for(Vendedor vendedor :s.getVendedores()) {
	   				if(vendedor.getId() == v.getId()) {
	   					flag=false;
	   				}
	   			}
	   		}
	   		
	   		//Si el vendedor no existe en ninguna lista, esta disponible
	   		if(flag==true) {
	   			listaAuxiliar.add(v);
	   		}
	   	}
   	
   	return listaAuxiliar;
   }



   
 //--------------------------------Traer los lotes para un pedido----------------------------
   
   public List<Lote> TraerLotesActivos(long idSucursal,long idProducto){	   
	   List<Lote> listaAuxiliar= new ArrayList<Lote>(); 
   	
	   Sucursal sucursal = sucursalConverter.modelToEntity(this.findById(idSucursal));
	   Producto producto = productoConverter.modelToEntity(productoService.findById(idProducto));
	   
	   //se itera entre los lotes de la sucursal dada
	   for(Lote l: sucursal.getLotes()) {
		   
		   
		   //Si el lote tiene el producto y la cantidad es mayor a 0 se lo agrega
		   if(l.getProducto().getId()== producto.getId() && l.getCantidadTotal()>0) {
			   listaAuxiliar.add(l);
	   		}
   		}
   		return listaAuxiliar;
   }
   
//--------------------------------Traer los lotes para un pedido con stock disponible----------------------------
   public List<Lote> TraerLotesActivosConStock(long idSucursal,long idProducto, int cantidad){	   
	   List<Lote> listaAuxiliar= new ArrayList<Lote>(); 
   	
	   Sucursal sucursal = sucursalConverter.modelToEntity(this.findById(idSucursal));
	   Producto producto = productoConverter.modelToEntity(productoService.findById(idProducto));
	   
	   //se itera entre los lotes de la sucursal dada
	   for(Lote l: sucursal.getLotes()) {
		   
		   
		   //Si el lote tiene el producto y la cantidad es mayor al stock pedido se agrega a la lista aux
		   if(l.getProducto().getId()== producto.getId() && l.getCantidadTotal() > cantidad) {
			   listaAuxiliar.add(l);
	   		}
   		}
   		return listaAuxiliar;
   }

@Override
public boolean restarLotes(long idSucursal, long idProducto, int cantidad) {
	
	boolean bandera = false;
	int indice=0;
	
	List<Lote> activos = this.TraerLotesActivos(idSucursal, idProducto);
	
	int totalDeLotes=0;
	
	//se calcula el total de cantidad de todos los lotes
	for(Lote lote : activos) {
		totalDeLotes+=lote.getCantidadTotal();
	}
	
	//si hay cantidad suficiente para abastecer la orden se hace, sino se devuelve en false
	if(totalDeLotes>=cantidad) {
	
	while(cantidad > 0) {
			if(activos.get(indice).getCantidadTotal() > cantidad) {
				activos.get(indice).setCantidadTotal(activos.get(indice).getCantidadTotal()-cantidad);
				loteService.Update(loteConverter.entityToModel(activos.get(indice)));
				cantidad=0;
			}
			else {
				cantidad -= activos.get(indice).getCantidadTotal();
				activos.get(indice).setCantidadTotal(0);
				loteService.Update(loteConverter.entityToModel(activos.get(indice)));
			}
			indice++;
		}
	
	bandera=true;
	}else {
		bandera=false;
	}
	return bandera;
}

@Override
public List<SucursalModel> calcularSucursalesCercanasConStockDisponible(ProductoModel productoModel, int cantidad,SucursalModel sucursalModel) {

    List<SucursalModel> sucursales = new ArrayList<>();
    Producto producto = productoConverter.modelToEntity(productoModel);
	Sucursal sucMasCercana=this.calcularSucursalesConStockDisponible(producto, cantidad).get(0);
    Sucursal sucMasCercana2=this.calcularSucursalesConStockDisponible(producto, cantidad).get(0);
	Sucursal sucursal = sucursalConverter.modelToEntity(sucursalModel);
	float distancia=this.calcularDistancia(sucursal,this.calcularSucursalesConStockDisponible(producto, cantidad).get(0));
	
	if(sucursal.getId() == this.calcularSucursalesConStockDisponible(producto, cantidad).get(0).getId()) {
		distancia=this.calcularDistancia(sucursal,this.calcularSucursalesConStockDisponible(producto, cantidad).get(1));
		sucMasCercana=this.calcularSucursalesConStockDisponible(producto, cantidad).get(1);
        sucMasCercana2=this.calcularSucursalesConStockDisponible(producto, cantidad).get(1);
	}
	
	for(int indice=0; indice<this.calcularSucursalesConStockDisponible(producto, cantidad).size(); indice++) {
		if(this.calcularDistancia(sucursal,this.calcularSucursalesConStockDisponible(producto, cantidad).get(indice)) < distancia && (sucursal.getId()!=this.calcularSucursalesConStockDisponible(producto, cantidad).get(indice).getId()))
		{
			distancia=this.calcularDistancia(sucursal,this.calcularSucursalesConStockDisponible(producto, cantidad).get(indice));
			sucMasCercana=this.calcularSucursalesConStockDisponible(producto, cantidad).get(indice);
		}
	}
	SucursalModel sucCercana = sucursalConverter.entityToModel(sucMasCercana);
	sucursales.add(sucCercana);
    distancia=this.calcularDistancia(sucursal,this.calcularSucursalesConStockDisponible(producto, cantidad).get(0));

    for(int indice=0; indice<this.calcularSucursalesConStockDisponible(producto, cantidad).size(); indice++) {
        if((!this.calcularSucursalesConStockDisponible(producto, cantidad).get(indice).equals(sucMasCercana))&& (this.calcularDistancia(sucursal,this.calcularSucursalesConStockDisponible(producto, cantidad).get(indice)) < distancia) && (sucursal.getId()!=this.calcularSucursalesConStockDisponible(producto, cantidad).get(indice).getId()))
        {
            distancia=this.calcularDistancia(sucursal,this.calcularSucursalesConStockDisponible(producto, cantidad).get(indice));
            sucMasCercana2=this.calcularSucursalesConStockDisponible(producto, cantidad).get(indice);
        }
    }
    SucursalModel sucCercana2 = sucursalConverter.entityToModel(sucMasCercana2);
    
    if(sucCercana2.getId()!=sucCercana.getId()) {
    sucursales.add(sucCercana2);}

    return sucursales;
}

	//----------------------------------Consigue las ventas de una sucursal filtrando entre dos fechas
	@Override
	public List<VentaModel> conseguirVentasSucursalYFecha(SucursalModel sucursalModel, LocalDate fechaInicio,
		LocalDate fechaFin) {
		List<VentaModel> ventas = this.conseguirVentasSucursal(sucursalModel);
		List<VentaModel> ventasPorFecha = new ArrayList<>();
		for(VentaModel v: ventas) {
			if( (v.getFecha().isAfter(fechaInicio) && v.getFecha().isBefore(fechaFin)) || v.getFecha().isEqual(fechaInicio) || v.getFecha().isEqual(fechaFin) ) {
				ventasPorFecha.add(v);
			}
		}
	return ventasPorFecha;
	}
	
	//----------------------------------Consigue los productos ventas de una sucursal filtrando entre dos fechas
	public List<ProductoModel> conseguirProductosPorFecha(SucursalModel sucursalModel, LocalDate fechaInicio, LocalDate fechaFin){
		List<VentaModel> ventas = this.conseguirVentasSucursalYFecha(sucursalModel, fechaInicio, fechaFin);
		List<ProductoModel> productos = new ArrayList<>();
		
		for(VentaModel venta: ventas) {
			for(PedidoModel pedido: venta.getPedidos()) {
				if(!productos.contains(pedido.getProducto())) {
					productos.add(pedido.getProducto());
				}
			}
		}
		
		return productos;
	}
}
