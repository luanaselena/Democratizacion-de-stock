package com.unla.Grupo30022020.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;


public class VentaModel {

	private long id;
	private Set<PedidoModel> pedidos= new HashSet<>();
	private VendedorModel vendedorEncargado;
	private ClienteModel cliente;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	private LocalTime hora;
	private float precioTotal;

	public VentaModel() {
	}

	public VentaModel(long id, VendedorModel vendedorEncargado, ClienteModel cliente, LocalDate fecha,
			LocalTime hora, float precioTotal,Set<PedidoModel> pedidos) {

		this.id = id;
		this.vendedorEncargado = vendedorEncargado;
		this.cliente = cliente;
		this.fecha = fecha;
		this.hora = hora;
		this.precioTotal = precioTotal;
		this.pedidos=pedidos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<PedidoModel> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<PedidoModel> pedidos) {
		this.pedidos = pedidos;
	}

	public VendedorModel getVendedorEncargado() {
		return vendedorEncargado;
	}

	public void setVendedorEncargado(VendedorModel vendedorEncargado) {
		this.vendedorEncargado = vendedorEncargado;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
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
