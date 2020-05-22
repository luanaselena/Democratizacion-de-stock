package com.unla.Grupo30022020.models;

import com.unla.Grupo30022020.entities.Producto;

public class PedidoModel {

	private long id;
	private int cantidad;
	private boolean aceptado;
	private ProductoModel producto;

	public PedidoModel() {
	}

	public PedidoModel(long id, int cantidad, ProductoModel producto) {

		this.id = id;
		this.cantidad = cantidad;
		this.aceptado=false;
		this.producto= producto;
	}

	public PedidoModel(int cantidad, ProductoModel producto) {

		this.cantidad = cantidad;
		this.aceptado=false;
		this.producto= producto;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public ProductoModel getProducto() {
		return producto;
	}

	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}

	

}
