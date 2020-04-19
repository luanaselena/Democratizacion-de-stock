package com.unla.oo2DemocratizacionStock.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="direccion")
public class Direccion{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="ciudad", nullable=false, length=30)
	private String ciudad;
	
	@Column(name="calle", nullable=false, length=30)
	private String calle;
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="latitud")
	private long latitud;
	
	@Column(name="longitud")
	private long longitud;
	
	public Direccion() {}

	public Direccion(long id, String ciudad, String calle, int numero, long latitud, long longitud) {
		this.id = id;
		this.ciudad = ciudad;
		this.calle = calle;
		this.numero = numero;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public long getLatitud() {
		return latitud;
	}

	public void setLatitud(long latitud) {
		this.latitud = latitud;
	}

	public long getLongitud() {
		return longitud;
	}

	public void setLongitud(long longitud) {
		this.longitud = longitud;
	}

}