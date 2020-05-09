package com.unla.Grupo30022020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo30022020.converters.GerenteConverter;
import com.unla.Grupo30022020.entities.Gerente;
import com.unla.Grupo30022020.models.GerenteModel;
import com.unla.Grupo30022020.repositories.IGerenteRepository;
import com.unla.Grupo30022020.services.IGerenteService;

@Service("gerenteService")
public class GerenteService implements IGerenteService{
	
	@Autowired
	@Qualifier("gerenteRepository")
	private IGerenteRepository gerenteRepository;
	
	@Autowired
	@Qualifier("gerenteConverter")
	private GerenteConverter gerenteConverter;

	@Override
	public List<Gerente> getAll() {
		return gerenteRepository.findAll();
	}

	@Override
	public GerenteModel findById(long id) {
		return gerenteConverter.entityToModel(gerenteRepository.findById(id));
	}

	@Override
	public GerenteModel findByDni(long dni) {
		return gerenteConverter.entityToModel(gerenteRepository.findByDni(dni));
	}

	@Override
	public GerenteModel insert(GerenteModel gerenteModel) {
		Gerente gerente = gerenteRepository.save(gerenteConverter.modelToEntity(gerenteModel));
		return gerenteConverter.entityToModel(gerente);
	}

	@Override
	public GerenteModel update(GerenteModel gerenteModel) {
		Gerente gerente = gerenteRepository.save(gerenteConverter.modelToEntity(gerenteModel));
		return gerenteConverter.entityToModel(gerente);
	}

	@Override
	public boolean remove(long id) {
		try{
            gerenteRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
	}

}
