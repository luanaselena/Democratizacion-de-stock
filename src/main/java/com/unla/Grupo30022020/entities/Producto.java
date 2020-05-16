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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + Float.floatToIntBits(precioUnitario);
		result = prime * result + (status ? 1231 : 1237);
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
		Producto other = (Producto) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fechaAlta == null) {
			if (other.fechaAlta != null)
				return false;
		} else if (!fechaAlta.equals(other.fechaAlta))
			return false;
		if (id != other.id)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (Float.floatToIntBits(precioUnitario) != Float.floatToIntBits(other.precioUnitario))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	
	
}
