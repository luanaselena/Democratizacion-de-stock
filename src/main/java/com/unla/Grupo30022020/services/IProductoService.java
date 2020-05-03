package com.unla.Grupo30022020.services;

import com.unla.Grupo30022020.entities.Producto;
import com.unla.Grupo30022020.models.ProductoModel;

import java.util.List;

public interface IProductoService {

    public List<Producto> getAll();
    public ProductoModel findById(long id);
    public ProductoModel findByDescripcion(String descripcion);
    public ProductoModel insert(ProductoModel productoModel);
    public ProductoModel update(ProductoModel productoModel);
    public boolean remove(long id);
}
