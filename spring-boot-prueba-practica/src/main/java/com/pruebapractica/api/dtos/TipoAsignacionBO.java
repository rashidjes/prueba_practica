package com.pruebapractica.api.dtos;

import java.io.Serializable;

public class TipoAsignacionBO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idTipoAsignacion;

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

}
