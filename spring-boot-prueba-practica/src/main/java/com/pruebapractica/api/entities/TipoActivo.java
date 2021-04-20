package com.pruebapractica.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.pruebapractica.api.dtos.TipoActivoBO;

@Entity
@Table(name = "tipo_activo")
public class TipoActivo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_activo_sequ")
	@SequenceGenerator(name = "tipo_activo_sequ", sequenceName = "tipo_activo_sequ", initialValue = 1, allocationSize = 1)
	@Column(name = "id_tipo_activo", nullable = false)
	private Long idTipoActivo;

	@Column(nullable = false)
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

	public TipoActivoBO toBO() {
		TipoActivoBO tipoActivoBO = new TipoActivoBO();

		tipoActivoBO.setIdTipoActivo(this.getIdTipoActivo());
		tipoActivoBO.setNombre(this.getNombre());

		return tipoActivoBO;
	}

}
