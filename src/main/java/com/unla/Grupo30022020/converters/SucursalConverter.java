package com.unla.Grupo30022020.converters;

import com.unla.Grupo30022020.entities.Lote;
import com.unla.Grupo30022020.entities.Sucursal;
import com.unla.Grupo30022020.entities.Vendedor;
import com.unla.Grupo30022020.models.LoteModel;
import com.unla.Grupo30022020.models.SucursalModel;
import com.unla.Grupo30022020.models.VendedorModel;

import java.util.HashSet;
import java.util.Set;

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
	
	@Autowired
	@Qualifier("loteConverter")
	private LoteConverter loteConverter;
	
	@Autowired
	@Qualifier("vendedorConverter")
	private VendedorConverter vendedorConverter;

    public SucursalModel entityToModel(Sucursal sucursal){
        return new SucursalModel(sucursal.getId(), direccionConverter.entityToModel(sucursal.getDireccion()), sucursal.getTelefono(), gerenteConverter.entityToModel(sucursal.getGerente()),this.LotesEntityToModel(sucursal.getLotes()),this.VendedorEntityToModel(sucursal.getVendedores()));
    }

    public Sucursal modelToEntity(SucursalModel sucursalModel){
        return new Sucursal(sucursalModel.getId(), direccionConverter.modelToEntity(sucursalModel.getDireccion()), sucursalModel.getTelefono(), gerenteConverter.modelToEntity(sucursalModel.getGerente()),this.LotesModelToEntity(sucursalModel.getLotes()),this.VendedorModelToEntity(sucursalModel.getVendedores()));
    }
    
    //Conversiones de la lista de Lote--------------------------------------------------
    
    public Set<LoteModel> LotesEntityToModel(Set<Lote> lotes){
    	Set<LoteModel> listaAuxiliar = new HashSet<>();
    	LoteModel auxiliar;
    	for(Lote l : lotes) {
    		
    		auxiliar = loteConverter.entityToModel(l);
    		listaAuxiliar.add(auxiliar);
    	}
    	
    	return listaAuxiliar;
    	
    }
    
    public Set<Lote> LotesModelToEntity(Set<LoteModel> lotes){
    	Set<Lote> listaAuxiliar = new HashSet<>();
    	Lote auxiliar;
    	for(LoteModel l : lotes) {
    		
    		auxiliar = loteConverter.modelToEntity(l);
    		listaAuxiliar.add(auxiliar);
    	}
    	
    	return listaAuxiliar;
    	
    }
    
    //Conversiones de la lista de Vendedor------------------------------------------------------
    
    public Set<VendedorModel> VendedorEntityToModel(Set<Vendedor> vendedores){
    	Set<VendedorModel> listaAuxiliar = new HashSet<>();
    	VendedorModel auxiliar;
    	for(Vendedor v : vendedores) {
    		
    		auxiliar = vendedorConverter.entityToModel(v);
    		listaAuxiliar.add(auxiliar);
    	}
    	
    	return listaAuxiliar;
    	
    }
    
    public Set<Vendedor> VendedorModelToEntity(Set<VendedorModel> vendedores){
    	Set<Vendedor> listaAuxiliar = new HashSet<>();
    	Vendedor auxiliar;
    	for(VendedorModel v : vendedores) {
    		
    		auxiliar = vendedorConverter.modelToEntity(v);
    		listaAuxiliar.add(auxiliar);
    	}
    	
    	return listaAuxiliar;
    	
    }
    
}
