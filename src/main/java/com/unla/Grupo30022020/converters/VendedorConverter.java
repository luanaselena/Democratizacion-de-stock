package com.unla.Grupo30022020.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo30022020.entities.Vendedor;
import com.unla.Grupo30022020.models.VendedorModel;

@Component("vendedorConverter")
public class VendedorConverter {

	public VendedorModel entityToModel(Vendedor vendedor){
        return new VendedorModel(vendedor.getId(), vendedor.getNombre(), vendedor.getApellido(), vendedor.getFechaDeNacimiento(), vendedor.getDni(), vendedor.getHorasPorJornada(), vendedor.getSueldoBasico(), vendedor.getPlus());
    }

    public Vendedor modelToEntity(VendedorModel vendedorModel){
        return new Vendedor(vendedorModel.getNombre(), vendedorModel.getApellido(), vendedorModel.getFechaDeNacimiento(), vendedorModel.getDni(), vendedorModel.getHorasPorJornada(), vendedorModel.getSueldoBasico(), vendedorModel.getPlus());
    }
    
}
