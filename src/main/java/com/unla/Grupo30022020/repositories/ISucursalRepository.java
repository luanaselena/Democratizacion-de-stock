package com.unla.Grupo30022020.repositories;
import com.unla.Grupo30022020.entities.Direccion;
import com.unla.Grupo30022020.entities.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("sucursalRepository")
public interface ISucursalRepository extends JpaRepository<Sucursal, Serializable> {
    public abstract Sucursal findById(long id);
    public abstract Sucursal findByDireccion(Direccion direccion);
}
