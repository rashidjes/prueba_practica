package com.pruebapractica.api.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "area")
public class Area {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "area_sequ")
	@SequenceGenerator(name = "area_sequ", sequenceName = "area_sequ", initialValue = 1, allocationSize = 1)
	@Column(name = "id_area", nullable = false)
	private Long idArea;

	@Column(nullable = false)
	private String nombre;

	@ManyToMany
	@JoinTable(name = "area_ciudad", joinColumns = @JoinColumn(name = "id_area"), inverseJoinColumns = @JoinColumn(name = "id_ciudad"))
	Set<Ciudad> ciudades = new HashSet<>();

	public Long getIdArea() {
		return idArea;
	}

	public void setIdArea(Long idArea) {
		this.idArea = idArea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(Set<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

}
