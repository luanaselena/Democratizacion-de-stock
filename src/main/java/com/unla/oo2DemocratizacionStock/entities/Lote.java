package com.unla.oo2DemocratizacionStock.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="lote")
public class Lote{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
	private Producto producto;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="cantidadTotal")
	private int cantidadTotal;
	
	@Column(name="fechaIngreso")
	private LocalDate fechaIngreso;
	
	public Lote() {}

	public Lote(long id, Producto producto, int cantidad, int cantidadTotal, LocalDate fechaIngreso) {
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

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
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
	