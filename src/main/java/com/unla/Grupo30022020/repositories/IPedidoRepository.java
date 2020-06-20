package com.unla.Grupo30022020.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo30022020.entities.Pedido;
import com.unla.Grupo30022020.entities.Producto;

@Repository("pedidoRepository")
public interface IPedidoRepository extends JpaRepository<Pedido, Serializable>{
	
	public abstract Pedido findById(long id);
	public abstract Pedido findByCantidad(int cantidad);
	public abstract Pedido findByProducto(Producto producto);
	

	
}
