package com.unla.Grupo30022020.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.Grupo30022020.converters.VentaConverter;
import com.unla.Grupo30022020.entities.Venta;
import com.unla.Grupo30022020.models.VentaModel;
import com.unla.Grupo30022020.repositories.IVentaRepository;
import com.unla.Grupo30022020.services.IVentaService;

@Service("ventaService")
public class VentaService implements IVentaService {

	@Autowired
	@Qualifier("ventaRepository")
	private IVentaRepository ventaRepository;

	@Autowired
	@Qualifier("ventaConverter")
	private VentaConverter ventaConverter;

	@Override
	public List<Venta> getAll() {
		return ventaRepository.findAll();
	}

	@Override
	public VentaModel findById(long id) {
		return ventaConverter.entityToModel(ventaRepository.findById(id));
	}

	@Override
	public VentaModel findByNroVenta(int nroVenta) {
		return ventaConverter.entityToModel(ventaRepository.findByNroVenta(nroVenta));
	}

	@Override
	public VentaModel insert(VentaModel ventaModel) {
		Venta venta = ventaRepository.save(ventaConverter.modelToEntity(ventaModel));
		return ventaConverter.entityToModel(venta);
	}

	@Override
	public VentaModel update(VentaModel ventaModel) {
		Venta venta = ventaRepository.save(ventaConverter.modelToEntity(ventaModel));
		return ventaConverter.entityToModel(venta);
	}

	@Override
	public boolean remove(long id) {
		try {
			ventaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
