package com.unla.Grupo30022020.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPedido;
	
	@Column
	private int cantidad;
	
	@Column
	private boolean aceptado;
	

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productoId", referencedColumnName = "id")
	private Producto producto;	
	
	public Pedido() {}

	public Pedido(long idPedido, int cantidad, boolean aceptado, Producto producto) {
		super();
		this.idPedido = idPedido;
		this.cantidad = cantidad;
		this.aceptado = aceptado;
		this.producto = producto;
	}

	public long getIdPedido() {
		return idPedido;
	}

	protected void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
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
	
	
}
