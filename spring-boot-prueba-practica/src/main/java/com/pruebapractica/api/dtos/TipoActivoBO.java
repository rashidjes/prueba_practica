package com.pruebapractica.api.dtos;

import java.io.Serializable;

public class TipoActivoBO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idTipoActivo;

	private String nombre;

	public Long getIdTipoActivo() {
		return idTipoActivo;
	}

	public void setIdTipoActivo(Long idTipoActivo) {
		this.idTipoActivo = idTipoActivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
