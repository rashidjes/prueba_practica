package com.pruebapractica.api.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "asignacion_area")
public class AsignacionArea {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asignacion_area_sequ")
	@SequenceGenerator(name = "asignacion_area_sequ", sequenceName = "asignacion_area_sequ", initialValue = 1, allocationSize = 1)
	@Column(name = "id_asig_area", nullable = false)
	private Long idAsigArea;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_activo", nullable = false, updatable = true)
	private ActivoFijo activoFijo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_area", nullable = false, updatable = true)
	private Area area;

	@Column(name = "fecha_asignacion", nullable = false)
	private Date fechaAsignacion;

	public Long getIdAsigArea() {
		return idAsigArea;
	}

	public void setIdAsigArea(Long idAsigArea) {
		this.idAsigArea = idAsigArea;
	}

	public ActivoFijo getActivoFijo() {
		return activoFijo;
	}

	public void setActivoFijo(ActivoFijo activoFijo) {
		this.activoFijo = activoFijo;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

}
