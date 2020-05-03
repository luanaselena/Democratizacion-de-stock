package com.unla.Grupo30022020.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo30022020.entities.Cliente;

@Repository("clienteRepository")
public interface IClienteRepository extends JpaRepository<Cliente, Serializable>{
	
	 public abstract Cliente findById(long id);
	 public abstract Cliente findByDni(long dni);
}
