package com.unla.Grupo30022020.services;

import com.unla.Grupo30022020.entities.Direccion;
import com.unla.Grupo30022020.entities.Lote;
import com.unla.Grupo30022020.entities.Producto;
import com.unla.Grupo30022020.entities.Sucursal;
import com.unla.Grupo30022020.entities.Vendedor;
import com.unla.Grupo30022020.models.ProductoModel;
import com.unla.Grupo30022020.models.SucursalModel;
import com.unla.Grupo30022020.models.VentaModel;

import java.util.List;

public interface ISucursalService {

    public List<Sucursal> getAll();

    public SucursalModel findById(long id);

    public SucursalModel findByDireccion(Direccion direccion);

    public SucursalModel insert(SucursalModel sucursalModel);

    public SucursalModel update(SucursalModel sucursalModel);

    public boolean remove(long id);
    
    public SucursalModel calcularSucursalMasCercana(SucursalModel sucursalModel);
    
    public float calcularDistancia(Sucursal sucursal1, Sucursal sucursal2);
    
    public SucursalModel EliminarLote(long idSucursal,long idLote);
    
    public SucursalModel EliminarVendedor(long idSucursal,long idVendedor);
    
    public List<Lote> TraerLotesDisponibles();
    
    public List<Vendedor> TraerVendedoresDisponibles();
    
    public List<Lote> TraerLotesActivos(long idSucursal,long idProducto);

    public boolean restarLotes(long idSucursal, long idProducto, int cantidad);
    
    public List<Sucursal> calcularSucursalesConStockDisponible(Producto producto, int cantidad);
    
    public List<Lote> TraerLotesActivosConStock(long idSucursal,long idProducto, int cantidad);
    
    public List<SucursalModel> calcularSucursalesCercanasConStockDisponible(ProductoModel productoModel, int cantidad, SucursalModel sucursal);
    
    public List<VentaModel>  conseguirVentasSucursal(SucursalModel sucursalModel);
}
