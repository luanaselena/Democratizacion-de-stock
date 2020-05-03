package com.unla.Grupo30022020.models;

public class ProductoModel {

    private long id;
    private boolean status;
    private String descripcion;
    private float precioUnitario;
    private String marca;

    public ProductoModel(){}

    public ProductoModel(long id, String descripcion, float precioUnitario, String marca) {
        this.id = id;
        this.status = true;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.marca = marca;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
