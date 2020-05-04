package com.unla.Grupo30022020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo30022020.converters.VendedorConverter;
import com.unla.Grupo30022020.entities.Vendedor;
import com.unla.Grupo30022020.models.VendedorModel;
import com.unla.Grupo30022020.repositories.IVendedorRepository;
import com.unla.Grupo30022020.services.IVendedorService;

@Service("vendedorService")
public class VendedorService implements IVendedorService{

	@Autowired
    @Qualifier("vendedorRepository")
    private IVendedorRepository vendedorRepository;

    @Autowired
    @Qualifier("vendedorConverter")
    private VendedorConverter vendedorConverter;

    @Override
    public List<Vendedor> getAll(){
        return vendedorRepository.findAll();
    }

    @Override
    public VendedorModel findById(long id){
        return vendedorConverter.entityToModel(vendedorRepository.findById(id));
    }

    @Override
    public VendedorModel findByDni(Long dni){
        return vendedorConverter.entityToModel(vendedorRepository.findByDni(dni));
    }

    @Override
    public VendedorModel insert(VendedorModel vendedorModel) {
        Vendedor vendedor = vendedorRepository.save(vendedorConverter.modelToEntity(vendedorModel));
        return vendedorConverter.entityToModel(vendedor);
    }

    @Override
    public VendedorModel update(VendedorModel vendedorModel) {
        Vendedor vendedor = vendedorRepository.save(vendedorConverter.modelToEntity(vendedorModel));
        return vendedorConverter.entityToModel(vendedor);
    }
    

    @Override
    public boolean remove(long id){
        try{
            vendedorRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
