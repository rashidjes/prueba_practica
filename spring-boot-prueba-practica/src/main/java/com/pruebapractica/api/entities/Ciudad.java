package com.pruebapractica.api.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ciudad")
public class Ciudad {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ciudad_sequ")
	@SequenceGenerator(name = "ciudad_sequ", sequenceName = "ciudad_sequ", initialValue = 1, allocationSize = 1)
	@Column(name = "id_ciudad", nullable = false)
	private Long idCiudad;

	@Column(nullable = false)
	private String nombre;

	@ManyToMany(mappedBy = "ciudades", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Area> areas = new HashSet<>();

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Area> getAreas() {
		return areas;
	}

	public void setAreas(Set<Area> areas) {
		this.areas = areas;
	}

	public void addArea(Area area) {
		if (area != null) {
			if (areas == null)
				areas = new HashSet<>();

			areas.add(area);
			area.getCiudades().add(this);
		}
	}

}
