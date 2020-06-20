package com.unla.Grupo30022020.services.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo30022020.converters.LoteConverter;
import com.unla.Grupo30022020.entities.Lote;
import com.unla.Grupo30022020.entities.Producto;
import com.unla.Grupo30022020.models.LoteModel;
import com.unla.Grupo30022020.repositories.ILoteRepository;
import com.unla.Grupo30022020.services.ILoteService;



@Service("loteService")
public class LoteService implements ILoteService {

	@Autowired
	@Qualifier("loteRepository")
	private ILoteRepository loteRepository;
	
	@Autowired
	@Qualifier("loteConverter")
	private LoteConverter loteConverter;
	
	@Autowired
	@Qualifier("productoService")
	private ProductoService productoService;

	
	@Override
	public List<Lote> getAll() {
		return loteRepository.findAll();
	}

	@Override
	public LoteModel Insert(LoteModel loteModel) {

		Lote lote = loteRepository.save(loteConverter.modelToEntity(loteModel));
		return loteConverter.entityToModel(lote);
	}
	
	@Override
	public LoteModel Update(LoteModel loteModel) {
		loteModel.setProducto(productoService.findById(loteModel.getProducto().getId()));
		Lote lote = loteRepository.save(loteConverter.modelToEntity(loteModel));
		return loteConverter.entityToModel(lote);
	}
	
	
	@Override
	public boolean remove(long id) {
		try {
			loteRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public LoteModel findById(long id) {
		return loteConverter.entityToModel(loteRepository.findById(id));
	}

	@Override
	public LoteModel findByProducto(Producto producto) {
		return loteConverter.entityToModel(loteRepository.findByProducto(producto));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}