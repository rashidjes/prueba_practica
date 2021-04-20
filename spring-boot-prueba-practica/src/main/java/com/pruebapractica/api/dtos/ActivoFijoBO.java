package com.pruebapractica.api.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ActivoFijoBO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idActivo;

	private String nombre;

	private String descripcion;

	private TipoActivoBO tipoActivoBO;

	private String serial;

	private int numeroInterno;

	private int peso;

	private int alto;

	private int ancho;

	private int largo;

	private BigDecimal valorCompra;

	private Date fechaCompra;

	private int estado;

	private TipoAsignacionBO tipoAsignacionBO;

	public Long getIdActivo() {
		return idActivo;
	}

	public void setIdActivo(Long idActivo) {
		this.idActivo = idActivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoActivoBO getTipoActivoBO() {
		return tipoActivoBO;
	}

	public void setTipoActivoBO(TipoActivoBO tipoActivoBO) {
		this.tipoActivoBO = tipoActivoBO;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public int getNumeroInterno() {
		return numeroInterno;
	}

	public void setNumeroInterno(int numeroInterno) {
		this.numeroInterno = numeroInterno;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public TipoAsignacionBO getTipoAsignacionBO() {
		return tipoAsignacionBO;
	}

	public void setTipoAsignacionBO(TipoAsignacionBO tipoAsignacionBO) {
		this.tipoAsignacionBO = tipoAsignacionBO;
	}

}
