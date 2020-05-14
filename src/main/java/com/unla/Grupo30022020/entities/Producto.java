package com.unla.Grupo30022020.entities;

import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="descripcion", length=100)
	private String descripcion;
	
	@Column(name="precioUnitario")
	private float precioUnitario;
	
	@Column(name="fechaAlta")
	@CreationTimestamp
	private LocalDate fechaAlta;
	
	@Column(name="marca", length=45)
	private String marca;
	
	public Producto() {}

	public Producto(String descripcion, float precioUnitario, String marca) {
		super();
		this.status = true;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.marca = marca;
	}

	public Producto(Long id, String descripcion, float precioUnitario, String marca) {
		super();
		this.id = id;
		this.status = true;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.marca = marca;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
