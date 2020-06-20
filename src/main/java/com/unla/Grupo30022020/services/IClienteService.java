package com.unla.Grupo30022020.services;

import java.util.List;

import com.unla.Grupo30022020.entities.Cliente;
import com.unla.Grupo30022020.models.ClienteModel;

public interface IClienteService {
	public List<Cliente> getAll();
    public ClienteModel findById(long id);
    public ClienteModel findByDni(long dni);
    public ClienteModel insert(ClienteModel clienteModel);
    public ClienteModel update(ClienteModel clienteModel);
    public boolean remove(long id);
}
