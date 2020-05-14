package com.unla.Grupo30022020.converters;

import com.unla.Grupo30022020.entities.Sucursal;
import com.unla.Grupo30022020.models.SucursalModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("sucursalConverter")
public class SucursalConverter {
	
	@Autowired
	@Qualifier("direccionConverter")
	private DireccionConverter direccionConverter;
	
	@Autowired
	@Qualifier("gerenteConverter")
	private GerenteConverter gerenteConverter;

    public SucursalModel entityToModel(Sucursal sucursal){
        return new SucursalModel(sucursal.getId(), direccionConverter.entityToModel(sucursal.getDireccion()), sucursal.getTelefono(), gerenteConverter.entityToModel(sucursal.getGerente()));
    }

    public Sucursal modelToEntity(SucursalModel sucursalModel){
        return new Sucursal(sucursalModel.getId(), direccionConverter.modelToEntity(sucursalModel.getDireccion()), sucursalModel.getTelefono(), gerenteConverter.modelToEntity(sucursalModel.getGerente()));
    }
    
}
