package com.unla.Grupo30022020.models;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + cantidadTotal;
		result = prime * result + ((fechaIngreso == null) ? 0 : fechaIngreso.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoteModel other = (LoteModel) obj;
		if (cantidad != other.cantidad)
			return false;
		if (cantidadTotal != other.cantidadTotal)
			return false;
		if (fechaIngreso == null) {
			if (other.fechaIngreso != null)
				return false;
		} else if (!fechaIngreso.equals(other.fechaIngreso))
			return false;
		if (id != other.id)
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}
	
	
	
}
