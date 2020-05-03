package com.unla.Grupo30022020.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Sucursal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSucursal;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ubicacionId", referencedColumnName = "id")
	private Direccion ubicacion;
	
	@Column
	private long telefono;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "gerenteId", referencedColumnName = "id")
//	private Gerente gerente;
//
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "vendedorId", referencedColumnName = "id")
//	private Set<Vendedor> vendedores;

	
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Lote> lotes;
	
	public Sucursal() {}

	public Sucursal(long idSucursal, Direccion ubicacion, long telefono
//			Gerente gerente, Set<Vendedor> vendedores,
//			Set<Lote> lotes
			) {
		super();
		this.idSucursal = idSucursal;
		this.ubicacion = ubicacion;
		this.telefono = telefono;
//		this.gerente = gerente;
//		this.vendedores = vendedores;
//		this.lotes = lotes;
	}

	public long getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(long idSucursal) {
		this.idSucursal = idSucursal;
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

//	public Gerente getGerente() {
//		return gerente;
//	}
//
//	public void setGerente(Gerente gerente) {
//		this.gerente = gerente;
//	}
//
//	public Set<Vendedor> getVendedores() {
//		return vendedores;
//	}
//
//	public void setVendedores(Set<Vendedor> vendedores) {
//		this.vendedores = vendedores;
//	}

//	public Set<Lote> getLotes() {
//		return lotes;
//	}
//
//	public void setLotes(Set<Lote> lotes) {
//		this.lotes = lotes;
//	}
//	
	
}
