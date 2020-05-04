package com.unla.Grupo30022020.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="sucursal")
public class Sucursal {
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ubicacionId", referencedColumnName = "id")
	private Direccion ubicacion;
	
	@Column(name="telefono")
	private long telefono;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gerenteId", referencedColumnName = "id")
	private Gerente gerente;

	@OneToMany(fetch = FetchType.LAZY)
	private Set<Vendedor> vendedores = new HashSet<>();

	
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Lote> lotes = new HashSet<>();;
	
	public Sucursal() {}

	public Sucursal(long id, Direccion ubicacion, long telefono, Gerente gerente) {
		super();
		this.id = id;
		this.ubicacion = ubicacion;
		this.telefono = telefono;
		this.gerente = gerente;
	}

	public Sucursal(Direccion ubicacion, long telefono, Gerente gerente) {
		super();
		this.ubicacion = ubicacion;
		this.telefono = telefono;
		this.gerente = gerente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Direccion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Direccion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Set<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(Set<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public Set<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(Set<Lote> lotes) {
		this.lotes = lotes;
	}

	
}
