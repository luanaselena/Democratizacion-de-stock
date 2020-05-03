package com.unla.Grupo30022020.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private int cantidad;
	
	@Column
	private boolean aceptado;
	

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productoid", referencedColumnName = "id")
	private Producto producto;	
	
	public Pedido() {}

	public Pedido(int cantidad, Producto producto) {
		this.cantidad = cantidad;
		this.aceptado = false;
		this.producto = producto;
	}
	
	public Pedido(long id, int cantidad, Producto producto) {
		this.id = id;
		this.cantidad = cantidad;
		this.aceptado = false;
		this.producto = producto;
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
	
	
}
