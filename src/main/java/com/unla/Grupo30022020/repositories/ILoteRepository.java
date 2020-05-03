package com.unla.Grupo30022020.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.unla.Grupo30022020.entities.Lote;
import com.unla.Grupo30022020.entities.Producto;

@Repository("loteRepository")
public interface ILoteRepository extends JpaRepository<Lote, Serializable> {
	
	public abstract Lote findById(long id);
	
	public abstract Lote findByProducto(Producto producto);
	
}