package com.unla.Grupo30022020.services.implementation;

import com.unla.Grupo30022020.converters.ProductoConverter;
import com.unla.Grupo30022020.entities.Producto;
import com.unla.Grupo30022020.models.ProductoModel;
import com.unla.Grupo30022020.repositories.IProductoRepository;
import com.unla.Grupo30022020.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productoService")
public class ProductoService implements IProductoService {

    @Autowired
    @Qualifier("productoRepository")
    private IProductoRepository productoRepository;

    @Autowired
    @Qualifier("productoConverter")
    private ProductoConverter productoConverter;

    @Override
    public List<Producto> getAll(){
        return productoRepository.findAll();
    }

    @Override
    public ProductoModel findById(long id){
        return productoConverter.entityToModel(productoRepository.findById(id));
    }

    @Override
    public ProductoModel findByDescripcion(String descripcion){
        return productoConverter.entityToModel(productoRepository.findByDescripcion(descripcion));
    }

    @Override
    public ProductoModel insert(ProductoModel productoModel) {

        Producto producto = productoRepository.save(productoConverter.modelToEntity(productoModel));
        return productoConverter.entityToModel(producto);
    }

    @Override
    public ProductoModel update(ProductoModel productoModel) {

        Producto producto = productoRepository.save(productoConverter.modelToEntity(productoModel));
        return productoConverter.entityToModel(producto);
    }

    @Override
    public boolean remove(long id){
        try{
            productoRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
