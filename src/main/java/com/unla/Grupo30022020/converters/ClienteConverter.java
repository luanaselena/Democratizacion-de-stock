package com.unla.Grupo30022020.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo30022020.entities.Cliente;
import com.unla.Grupo30022020.models.ClienteModel;

@Component("clienteConverter")
public class ClienteConverter {
	
	 public ClienteModel entityToModel(Cliente cliente){
	        return new ClienteModel(cliente.getId(), cliente.getNombre(), cliente.getApellido(), cliente.getFechaDeNacimiento(), cliente.getDni(), cliente.getMail());
	    }

	    public Cliente modelToEntity(ClienteModel clienteModel){
	        return new Cliente(clienteModel.getNombre(), clienteModel.getApellido(), clienteModel.getFechaDeNacimiento(), clienteModel.getDni(), clienteModel.getMail());
	    }
}
