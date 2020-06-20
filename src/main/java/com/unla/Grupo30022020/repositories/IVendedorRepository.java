package com.unla.Grupo30022020.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo30022020.entities.Vendedor;

@Repository("vendedorRepository")
public interface IVendedorRepository extends JpaRepository<Vendedor, Serializable> {
	
	public abstract Vendedor findById(long id);
    public abstract Vendedor findByDni(Long dni);
    
}
