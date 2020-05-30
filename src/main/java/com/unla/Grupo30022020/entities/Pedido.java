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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private int cantidad;
	
	@Column
	private boolean aceptado = false;
	

	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "productoid", referencedColumnName = "id")
	private Producto producto;	
	
	public Pedido() {}

	public Pedido(int cantidad, Producto producto) {
		this.cantidad = cantidad;
		this.aceptado = false;
		this.producto = producto;
	}
	
	public Pedido(long id, int cantidad, Producto producto,boolean aceptado) {
		this.id = id;
		this.cantidad = cantidad;
		this.aceptado = aceptado;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (aceptado ? 1231 : 1237);
		result = prime * result + cantidad;
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
		Pedido other = (Pedido) obj;
		if (aceptado != other.aceptado)
			return false;
		if (cantidad != other.cantidad)
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
