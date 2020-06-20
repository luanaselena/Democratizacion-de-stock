package com.unla.Grupo30022020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo30022020.converters.ClienteConverter;
import com.unla.Grupo30022020.entities.Cliente;
import com.unla.Grupo30022020.models.ClienteModel;
import com.unla.Grupo30022020.repositories.IClienteRepository;
import com.unla.Grupo30022020.services.IClienteService;

@Service("clienteService")
public class ClienteService implements IClienteService{
	
	@Autowired
	@Qualifier("clienteRepository")
	private IClienteRepository clienteRepository;
	
	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;

	@Override
	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}

	@Override
	public ClienteModel findById(long id) {
		// TODO Auto-generated method stub
		return clienteConverter.entityToModel(clienteRepository.findById(id));
	}

	@Override
	public ClienteModel findByDni(long dni) {
		// TODO Auto-generated method stub
		return clienteConverter.entityToModel(clienteRepository.findByDni(dni));
	}

	@Override
	public ClienteModel insert(ClienteModel clienteModel) {
		Cliente cliente = clienteRepository.save(clienteConverter.modelToEntity(clienteModel));
		return clienteConverter.entityToModel(cliente);
	}

	@Override
	public ClienteModel update(ClienteModel clienteModel) {
		Cliente cliente = clienteRepository.save(clienteConverter.modelToEntity(clienteModel));
		return clienteConverter.entityToModel(cliente);
	}

	@Override
	public boolean remove(long id) {
		try{
            clienteRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
	}

}
