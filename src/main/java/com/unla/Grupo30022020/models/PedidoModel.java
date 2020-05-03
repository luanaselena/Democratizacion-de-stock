package com.unla.Grupo30022020.models;

import com.unla.Grupo30022020.entities.Producto;

public class PedidoModel {

	private long id;
	private int cantidad;
	private boolean aceptado;
	private Producto producto;

	public PedidoModel() {
	}

	public PedidoModel(long id, int cantidad,Producto producto) {

		this.id = id;
		this.cantidad = cantidad;
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

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	// FALTA AGREGAR PRODUCTO AL CONSTRUCTOR

}
