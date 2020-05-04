package com.unla.Grupo30022020.models;

import com.unla.Grupo30022020.entities.Direccion;
import com.unla.Grupo30022020.entities.Gerente;
import com.unla.Grupo30022020.entities.Lote;
import com.unla.Grupo30022020.entities.Vendedor;

import java.util.HashSet;
import java.util.Set;

public class SucursalModel {

    private long id;
    private Direccion ubicacion;
    private long telefono;
    private Gerente gerente;
    private Set<Vendedor> vendedores=new HashSet<>();
    private Set<Lote> lotes=new HashSet<>();

    public SucursalModel(){}

    public SucursalModel(long id, Direccion ubicacion, long telefono, Gerente gerente) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.gerente = gerente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Direccion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Direccion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Set<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(Set<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public Set<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(Set<Lote> lotes) {
        this.lotes = lotes;
    }
}
