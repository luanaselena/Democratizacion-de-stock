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
    
    @Autowired
	@Qualifier("direccionService")
	private DireccionService direccionService;
    
    @Autowired
	@Qualifier("gerenteService")
	private GerenteService gerenteService;

    @Override
    public List<Sucursal> getAll(){
        return sucursalRepository.findAll();
    }

    @Override
    public SucursalModel findById(long id){
        return sucursalConverter.entityToModel(sucursalRepository.findById(id));
    }

    @Override
    public SucursalModel findByDireccion(Direccion direccion){
        return sucursalConverter.entityToModel(sucursalRepository.findByDireccion(direccion));
    }

    @Override
    public SucursalModel insert(SucursalModel sucursalModel) {
    	
    	sucursalModel.setDireccion(direccionService.findById(sucursalModel.getDireccion().getId()));
    	sucursalModel.setGerente(gerenteService.findById(sucursalModel.getGerente().getId()));
    	
        Sucursal sucursal = sucursalRepository.save(sucursalConverter.modelToEntity(sucursalModel));
        return sucursalConverter.entityToModel(sucursal);
    }

    @Override
    public SucursalModel update(SucursalModel sucursalModel) {
    	sucursalModel.setDireccion(direccionService.findById(sucursalModel.getDireccion().getId()));
    	sucursalModel.setGerente(gerenteService.findById(sucursalModel.getGerente().getId()));
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
    
    @Override
    public float calcularDistancia(Sucursal sucursal1, Sucursal sucursal2) {
    	return (float) Math.sqrt((Math.pow((sucursal1.getDireccion().getLatitud() - sucursal2.getDireccion().getLatitud()), 2) +
				((Math.pow((sucursal1.getDireccion().getLongitud() - sucursal2.getDireccion().getLongitud()), 2)))));
	}
    
    @Override
    public SucursalModel calcularSucursalMasCercana(SucursalModel sucursalModel) {
		int indice=0;
		Sucursal sucMasCercana=null;
		float distancia=0;
		Sucursal sucursal = sucursalConverter.modelToEntity(sucursalModel);
		
		if(sucursal.equals(this.getAll().get(0))) {
			distancia=this.calcularDistancia(sucursal,this.getAll().get(1));
			sucMasCercana=this.getAll().get(1);
		}
		
		else {
			distancia=this.calcularDistancia(sucursal,this.getAll().get(0));
			sucMasCercana=this.getAll().get(0);
		}
		
		for(indice=1; indice<this.getAll().size(); indice++) {
			if(this.calcularDistancia(sucursal,this.getAll().get(indice)) < distancia && sucursal!=this.getAll().get(indice))
			{
				distancia=this.calcularDistancia(sucursal,this.getAll().get(indice));
				sucMasCercana=this.getAll().get(indice);
			}
		}
		
		SucursalModel sucMasCercanaModel = sucursalConverter.entityToModel(sucMasCercana);
		
		return sucMasCercanaModel;
	}
}
