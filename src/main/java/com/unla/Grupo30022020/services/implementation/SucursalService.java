package com.unla.Grupo30022020.services.implementation;

import com.unla.Grupo30022020.converters.SucursalConverter;
import com.unla.Grupo30022020.entities.Direccion;
import com.unla.Grupo30022020.entities.Sucursal;
import com.unla.Grupo30022020.models.SucursalModel;
import com.unla.Grupo30022020.repositories.ISucursalRepository;
import com.unla.Grupo30022020.services.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sucursalService")
public class SucursalService implements ISucursalService {

    @Autowired
    @Qualifier("sucursalRepository")
    private ISucursalRepository sucursalRepository;

    @Autowired
    @Qualifier("sucursalConverter")
    private SucursalConverter sucursalConverter;

    @Override
    public List<Sucursal> getAll(){
        return sucursalRepository.findAll();
    }

    @Override
    public SucursalModel findById(long id){
        return sucursalConverter.entityToModel(sucursalRepository.findById(id));
    }

    @Override
    public SucursalModel findByUbicacion(Direccion ubicacion){
        return sucursalConverter.entityToModel(sucursalRepository.findByUbicacion(ubicacion));
    }

    @Override
    public SucursalModel insert(SucursalModel sucursalModel) {

        Sucursal sucursal = sucursalRepository.save(sucursalConverter.modelToEntity(sucursalModel));
        return sucursalConverter.entityToModel(sucursal);
    }

    @Override
    public SucursalModel update(SucursalModel sucursalModel) {

        Sucursal sucursal = sucursalRepository.save(sucursalConverter.modelToEntity(sucursalModel));
        return sucursalConverter.entityToModel(sucursal);
    }

    @Override
    public boolean remove(long id){
        try{
            sucursalRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
