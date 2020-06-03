package com.unla.Grupo30022020.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="sucursal")
public class Sucursal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Direccion direccion;
	
	@Column(name="telefono")
	private long telefono;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Gerente gerente;

	@OneToMany(fetch = FetchType.LAZY)
	private Set<Vendedor> vendedores = new HashSet<>();

	
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Lote> lotes = new HashSet<>();
	
	public Sucursal() {}

	public Sucursal(long id, Direccion direccion, long telefono, Gerente gerente, Set<Lote> lotes,Set<Vendedor> vendedores) {
		this.id = id;
		this.direccion = direccion;
		this.telefono = telefono;
		this.gerente = gerente;
		this.lotes=lotes;
		this.vendedores=vendedores;
	}

	public Sucursal(long id, Direccion direccion, long telefono, Gerente gerente) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.telefono = telefono;
		this.gerente = gerente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
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
