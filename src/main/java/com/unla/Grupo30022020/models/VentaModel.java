package com.unla.Grupo30022020.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import com.unla.Grupo30022020.entities.*;

public class VentaModel {

	private long id;
	private int nroVenta;
	private Set<Pedido> pedidos;
	private Vendedor vendedorEncargado;
	private Cliente cliente;
	private LocalDate fecha;
	private LocalTime hora;
	private float precioTotal;

	public VentaModel() {
	}

	public VentaModel(long id, int nroVenta, Vendedor vendedorEncargado, Cliente cliente, LocalDate fecha,
			LocalTime hora, float precioTotal) {

		this.id = id;
		this.nroVenta = nroVenta;
		this.vendedorEncargado = vendedorEncargado;
		this.cliente = cliente;
		this.fecha = fecha;
		this.hora = hora;
		this.precioTotal = precioTotal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumVenta() {
		return nroVenta;
	}

	public void setNumVenta(int numVenta) {
		this.nroVenta = numVenta;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Vendedor getVendedorEncargado() {
		return vendedorEncargado;
	}

	public void setVendedorEncargado(Vendedor vendedorEncargado) {
		this.vendedorEncargado = vendedorEncargado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
	

}
