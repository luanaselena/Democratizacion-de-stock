package com.unla.Grupo30022020.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo30022020.entities.Gerente;
import com.unla.Grupo30022020.models.GerenteModel;

@Component("gerenteConverter")
public class GerenteConverter {
	public GerenteModel entityToModel(Gerente gerente){
        return new GerenteModel(gerente.getId(), gerente.getNombre(), gerente.getApellido(), gerente.getFechaDeNacimiento(), gerente.getDni(), gerente.getHorasPorJornada(), gerente.getSueldoBasico());
    }

    public Gerente modelToEntity(GerenteModel gerenteModel){
        return new Gerente(gerenteModel.getNombre(), gerenteModel.getApellido(), gerenteModel.getFechaDeNacimiento(), gerenteModel.getDni(), gerenteModel.getHorasPorJornada(), gerenteModel.getSueldoBasico());
    }
}
