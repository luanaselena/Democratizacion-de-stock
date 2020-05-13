package com.unla.Grupo30022020.models;

import java.sql.Date;

public class LoteModel {

	private long id;
	
	private ProductoModel producto;

	private int cantidad;

	private int cantidadTotal;

	private Date fechaIngreso;

	public LoteModel() {}

	public LoteModel(long id, ProductoModel producto, int cantidad, int cantidadTotal, Date fechaIngreso) {
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.cantidadTotal = cantidadTotal;
		this.fechaIngreso = fechaIngreso;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProductoModel getProducto() {
		return producto;
	}

	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
