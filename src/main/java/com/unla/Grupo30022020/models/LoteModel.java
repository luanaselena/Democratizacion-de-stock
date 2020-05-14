package com.unla.Grupo30022020.models;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class LoteModel {

	private long id;
	
	private ProductoModel producto;

	private int cantidad;

	private int cantidadTotal;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaIngreso;

	public LoteModel() {}

	public LoteModel(long id, ProductoModel producto, int cantidad, int cantidadTotal, LocalDate fechaIngreso) {
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

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
