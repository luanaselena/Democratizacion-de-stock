package com.unla.Grupo30022020.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo30022020.entities.Gerente;

@Repository("gerenteRepository")
public interface IGerenteRepository extends JpaRepository<Gerente, Serializable>{
	public abstract Gerente findById(long id);
	 public abstract Gerente findByDni(long dni);
}
