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
@Table(name = "asignacion_persona")
public class AsignacionPersona {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asignacion_persona_sequ")
	@SequenceGenerator(name = "asignacion_persona_sequ", sequenceName = "asignacion_persona_sequ", initialValue = 1, allocationSize = 1)
	@Column(name = "id_asig_persona", nullable = false)
	private Long idAsigPersona;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_activo", nullable = false, updatable = true)
	private ActivoFijo activoFijo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_persona", nullable = false, updatable = true)
	private Persona persona;

	@Column(name = "fecha_asignacion", nullable = false)
	private Date fechaAsignacion;

	public Long getIdAsigPersona() {
		return idAsigPersona;
	}

	public void setIdAsigPersona(Long idAsigPersona) {
		this.idAsigPersona = idAsigPersona;
	}

	public ActivoFijo getActivoFijo() {
		return activoFijo;
	}

	public void setActivoFijo(ActivoFijo activoFijo) {
		this.activoFijo = activoFijo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

}
