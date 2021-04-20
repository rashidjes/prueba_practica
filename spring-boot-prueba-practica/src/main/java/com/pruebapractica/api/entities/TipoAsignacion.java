package com.pruebapractica.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.pruebapractica.api.dtos.TipoAsignacionBO;

@Entity
@Table(name = "tipo_asignacion")
public class TipoAsignacion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_asignacion_sequ")
	@SequenceGenerator(name = "tipo_asignacion_sequ", sequenceName = "tipo_asignacion_sequ", initialValue = 1, allocationSize = 1)
	@Column(name = "id_tipo_asignacion", nullable = false)
	private Long idTipoAsignacion;

	@Column(nullable = false)
	private String nombre;

	public Long getIdTipoAsignacion() {
		return idTipoAsignacion;
	}

	public void setIdTipoAsignacion(Long idTipoAsignacion) {
		this.idTipoAsignacion = idTipoAsignacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoAsignacionBO toBO() {
		TipoAsignacionBO tipoAsignacionBO = new TipoAsignacionBO();

		tipoAsignacionBO.setIdTipoAsignacion(this.getIdTipoAsignacion());
		tipoAsignacionBO.setNombre(this.getNombre());

		return tipoAsignacionBO;
	}

}
