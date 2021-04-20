package com.pruebapractica.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebapractica.api.entities.TipoActivo;
import com.pruebapractica.api.exceptions.NotFoundException;
import com.pruebapractica.api.services.TipoActivoService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TipoActivoController {

	@Autowired
	private TipoActivoService tipoActivoService;

	@GetMapping("/obtener-todos-tipos-activos")
	public List<TipoActivo> obtenerTodosTiposActivos() {
		List<TipoActivo> lTiposActivos = tipoActivoService.getAllTiposActivos();

		if (lTiposActivos.size() == 0)
			throw new NotFoundException("No se encontró ningún tipo de activo");

		return lTiposActivos;

	}
}
