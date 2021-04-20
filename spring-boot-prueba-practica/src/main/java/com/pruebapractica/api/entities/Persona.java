package com.pruebapractica.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_sequ")
	@SequenceGenerator(name = "persona_sequ", sequenceName = "persona_sequ", initialValue = 1, allocationSize = 1)
	@Column(name = "id_persona", nullable = false)
	private Long idPersona;

	@Column(nullable = false)
	private String nombres;

	@Column(nullable = false)
	private String apellidos;

	@Column(nullable = false)
	private int identificacion;

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

}
