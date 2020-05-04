package com.unla.Grupo30022020.services;

import com.unla.Grupo30022020.entities.Direccion;
import com.unla.Grupo30022020.entities.Sucursal;
import com.unla.Grupo30022020.models.SucursalModel;

import java.util.List;

public interface ISucursalService {

    public List<Sucursal> getAll();

    public SucursalModel findById(long id);

    public SucursalModel findByUbicacion(Direccion ubicacion);

    public SucursalModel insert(SucursalModel sucursalModelModel);

    public SucursalModel update(SucursalModel sucursalModel);

    public boolean remove(long id);
}
