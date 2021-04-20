package com.pruebapractica.api.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.pruebapractica.api.dtos.ActivoFijoBO;

@Entity
@Table(name = "activo_fijo")
public class ActivoFijo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activo_fijo_sequ")
	@SequenceGenerator(name = "activo_fijo_sequ", sequenceName = "activo_fijo_sequ", initialValue = 1, allocationSize = 1)
	@Column(name = "id_activo", nullable = false)
	private Long idActivo;

	@Column(nullable = false)
	private String nombre;

	@Lob
	@Column(nullable = false)
	private byte[] descripcion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_activo", nullable = false, updatable = true)
	private TipoActivo tipoActivo;

	@Column(nullable = false)
	private String serial;

	@Column(name = "numero_interno", nullable = false)
	private int numeroInterno;

	@Column
	private int peso;

	@Column
	private int alto;

	@Column
	private int ancho;

	@Column
	private int largo;

	@Column(name = "valor_compra", nullable = false)
	private BigDecimal valorCompra;

	@Column(name = "fecha_compra", nullable = false)
	private Date fechaCompra;

	@Column(name = "estado", nullable = false, columnDefinition = "integer default 1")
	private int estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_asignacion", nullable = false, updatable = true)
	private TipoAsignacion tipoAsignacion;

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

	public byte[] getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(byte[] descripcion) {
		this.descripcion = descripcion;
	}

	public TipoActivo getTipoActivo() {
		return tipoActivo;
	}

	public void setTipoActivo(TipoActivo tipoActivo) {
		this.tipoActivo = tipoActivo;
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

	public TipoAsignacion getTipoAsignacion() {
		return tipoAsignacion;
	}

	public void setTipoAsignacion(TipoAsignacion tipoAsignacion) {
		this.tipoAsignacion = tipoAsignacion;
	}

	public ActivoFijoBO toBO() {
		ActivoFijoBO activoFijoBO = new ActivoFijoBO();

		activoFijoBO.setIdActivo(this.getIdActivo());
		activoFijoBO.setNombre(this.getNombre());

		if (this.getDescripcion() != null)
			activoFijoBO.setDescripcion(new String(this.getDescripcion()));

		activoFijoBO.setTipoActivoBO(this.getTipoActivo().toBO());
		activoFijoBO.setSerial(this.getSerial());
		activoFijoBO.setNumeroInterno(this.getNumeroInterno());
		activoFijoBO.setPeso(this.getPeso());
		activoFijoBO.setAlto(this.getAlto());
		activoFijoBO.setAncho(this.getAncho());
		activoFijoBO.setLargo(this.getLargo());
		activoFijoBO.setValorCompra(this.getValorCompra());
		activoFijoBO.setFechaCompra(this.getFechaCompra());
		activoFijoBO.setEstado(this.getEstado());
		activoFijoBO.setTipoAsignacionBO(this.getTipoAsignacion().toBO());

		return activoFijoBO;
	}

}
