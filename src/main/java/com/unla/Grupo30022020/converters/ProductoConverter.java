package com.unla.Grupo30022020.converters;

import com.unla.Grupo30022020.entities.Producto;
import com.unla.Grupo30022020.models.ProductoModel;
import org.springframework.stereotype.Component;

@Component("productoConverter")
public class ProductoConverter {

    public ProductoModel entityToModel(Producto producto){
        return new ProductoModel(producto.getId(), producto.getDescripcion(), producto.getPrecioUnitario(),
                producto.getFechaAlta(), producto.getMarca());
    }

    public Producto modelToEntity(ProductoModel productoModel){
        return new Producto(productoModel.getId(), productoModel.getDescripcion(), productoModel.getPrecioUnitario(),
                productoModel.getFechaAlta(), productoModel.getMarca());
    }
}
