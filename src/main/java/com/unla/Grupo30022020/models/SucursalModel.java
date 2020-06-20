package com.unla.Grupo30022020.models;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SucursalModel {

    private long id;
    private DireccionModel direccion;
    private long telefono;
    private GerenteModel gerente;
    private Set<VendedorModel> vendedores=new HashSet<>();
    private Set<LoteModel> lotes=new HashSet<>();

    public SucursalModel(){}

    public SucursalModel(long id, DireccionModel direccion, long telefono, GerenteModel gerente,Set<LoteModel> lotes,Set<VendedorModel> vendedores) {
        this.id = id;
        this.direccion = direccion;
        this.telefono = telefono;
        this.gerente = gerente;
    	this.lotes=lotes;
    	this.vendedores=vendedores;
    }
    
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

    public Set<VendedorModel> getVendedores() {
        return vendedores;
    }

    public void setVendedores(Set<VendedorModel> vendedores) {
        this.vendedores = vendedores;
    }

    public Set<LoteModel> getLotes() {
        return lotes;
    }

    public void setLotes(Set<LoteModel> lotes) {
        this.lotes = lotes;
    }

    public boolean equals(SucursalModel sucursalModel) {
        return id == sucursalModel.id &&
                telefono == sucursalModel.telefono &&
                Objects.equals(direccion, sucursalModel.direccion) &&
                Objects.equals(gerente, sucursalModel.gerente) &&
                Objects.equals(vendedores, sucursalModel.vendedores) &&
                Objects.equals(lotes, sucursalModel.lotes);
    }
}
