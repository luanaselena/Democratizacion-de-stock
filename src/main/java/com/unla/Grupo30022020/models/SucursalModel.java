package com.unla.Grupo30022020.models;

import com.unla.Grupo30022020.entities.Direccion;
import com.unla.Grupo30022020.entities.Gerente;
import com.unla.Grupo30022020.entities.Lote;
import com.unla.Grupo30022020.entities.Vendedor;

import java.util.HashSet;
import java.util.Set;

public class SucursalModel {

    private long id;
    private DireccionModel direccion;
    private long telefono;
    private GerenteModel gerente;
    private Set<Vendedor> vendedores=new HashSet<>();
    private Set<Lote> lotes=new HashSet<>();

    public SucursalModel(){}

    public SucursalModel(long id, DireccionModel direccion, long telefono, GerenteModel gerente) {
        this.id = id;
        this.direccion = direccion;
        this.telefono = telefono;
        this.gerente = gerente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DireccionModel getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionModel direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public GerenteModel getGerente() {
        return gerente;
    }

    public void setGerente(GerenteModel gerente) {
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
