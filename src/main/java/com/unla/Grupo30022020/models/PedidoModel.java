package com.unla.Grupo30022020.models;


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
		PedidoModel other = (PedidoModel) obj;
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
