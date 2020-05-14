package com.unla.Grupo30022020.repositories;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unla.Grupo30022020.entities.Venta;

@Repository("ventaRepository")
public interface IVentaRepository extends JpaRepository<Venta, Serializable> {
	
	public abstract Venta findById(long id);
    public abstract Venta findByNroVenta(int nroVenta);
    
}
