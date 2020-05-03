package com.unla.Grupo30022020.repositories;

import com.unla.Grupo30022020.entities.Direccion;
import com.unla.Grupo30022020.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Serializable> {

    public abstract Producto findById(long id);
    public abstract Producto findByDescripcion(String descripcion);
}
