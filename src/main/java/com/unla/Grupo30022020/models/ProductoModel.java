package com.unla.Grupo30022020.models;

import java.time.LocalDate;

public class ProductoModel {

    private long id;
    private boolean status;
    private String descripcion;
    private float precioUnitario;
    private LocalDate fechaAlta;
    private String marca;

    public ProductoModel(){}

    public ProductoModel(long id, String descripcion, float precioUnitario, LocalDate fechaAlta, String marca) {
        this.id = id;
        this.status = true;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.fechaAlta = fechaAlta;
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

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
