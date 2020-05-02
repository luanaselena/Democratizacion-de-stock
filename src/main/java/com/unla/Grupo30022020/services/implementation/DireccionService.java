package com.unla.Grupo30022020.services.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo30022020.converters.DireccionConverter;
import com.unla.Grupo30022020.entities.Direccion;
import com.unla.Grupo30022020.models.DireccionModel;
import com.unla.Grupo30022020.repositories.IDireccionRepository;
import com.unla.Grupo30022020.services.IDireccionService;


@Service("direccionService")
public class DireccionService implements IDireccionService {

	@Autowired
	@Qualifier("direccionRepository")
	private IDireccionRepository direccionRepository;
	
	@Autowired
	@Qualifier("direccionConverter")
	private DireccionConverter direccionConverter;
	
	@Override
	public List<Direccion> getAll() {
		return direccionRepository.findAll();
	}

	@Override
	public DireccionModel insertOrUpdate(DireccionModel direccionModel) {
		Direccion direccion = direccionRepository.save(direccionConverter.modelToEntity(direccionModel));
		return direccionConverter.entityToModel(direccion);
	}

	@Override
	public boolean remove(long id) {
		try {
			direccionRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public DireccionModel findById(long id) {
		return direccionConverter.entityToModel(direccionRepository.findById(id));
	}

	@Override
	public DireccionModel findByCalle(String calle) {
		return direccionConverter.entityToModel(direccionRepository.findByCalle(calle));
	}
	
}