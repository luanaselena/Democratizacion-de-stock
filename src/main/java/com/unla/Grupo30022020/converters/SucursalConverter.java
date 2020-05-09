package com.unla.Grupo30022020.converters;

import com.unla.Grupo30022020.entities.Sucursal;
import com.unla.Grupo30022020.models.SucursalModel;
import org.springframework.stereotype.Component;

@Component("sucursalConverter")
public class SucursalConverter {

    public SucursalModel entityToModel(Sucursal sucursal){
        return new SucursalModel(sucursal.getId(), sucursal.getUbicacion(), sucursal.getTelefono(), sucursal.getGerente());
    }

    public Sucursal modelToEntity(SucursalModel sucursalModel){
        return new Sucursal(sucursalModel.getId(), sucursalModel.getUbicacion(), sucursalModel.getTelefono(), sucursalModel.getGerente());
    }
}
