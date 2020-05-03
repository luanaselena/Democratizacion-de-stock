package com.unla.Grupo30022020.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.unla.Grupo30022020.entities.Direccion;

@Repository("direccionRepository")
public interface IDireccionRepository extends JpaRepository<Direccion, Serializable> {
	
	public abstract Direccion findById(long id);
	
	public abstract Direccion findByCalle(String calle);
	
}