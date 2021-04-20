package com.pruebapractica.api.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebapractica.api.dtos.ActivoFijoBO;
import com.pruebapractica.api.entities.ActivoFijo;
import com.pruebapractica.api.exceptions.NotFoundException;
import com.pruebapractica.api.services.ActivoFijoService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ActivoFijoController {

	@Autowired
	private ActivoFijoService activoFijoService;

	@GetMapping("/obtener-activo-fijo-por-id-activo/{idActivo}")
	public Optional<ActivoFijo> obtenerActivoFijoPorIdActivo(@PathVariable Long idActivo) {
		Optional<ActivoFijo> optActivoFijo = activoFijoService.getActivoFijoByIdActivo(idActivo);

		if (!optActivoFijo.isPresent())
			throw new NotFoundException("No se encontró ningún activo fijo asociado al idActivo " + idActivo);

		return optActivoFijo;
	}

	@GetMapping("/obtener-activos-fijos-por-tipo-activo/{idTipoActivo}")
	public List<ActivoFijoBO> obtenerActivosFijosPorTipoActivo(@PathVariable Long idTipoActivo) {
		List<ActivoFijoBO> lActivoFijoBO = new ArrayList<>();
		List<ActivoFijo> lActivoFijo = activoFijoService.getActivosFijosByTipoActivo(idTipoActivo);

		if (lActivoFijo.size() > 0)
			for (int i = 0; i < lActivoFijo.size(); i++)
				lActivoFijoBO.add(lActivoFijo.get(i).toBO());
		else
			throw new NotFoundException("No se encontró ningún activo fijo asociado al idTipoActivo " + idTipoActivo);

		return lActivoFijoBO;
	}

	@GetMapping("/obtener-activos-fijos-por-fecha-compra/{fechaCompra}")
	public List<ActivoFijoBO> obtenerActivosFijosPorFechaCompra(@PathVariable Date fechaCompra) {
		List<ActivoFijoBO> lActivoFijoBO = new ArrayList<>();
		List<ActivoFijo> lActivoFijo = activoFijoService.getActivosFijosByFechaCompra(fechaCompra);

		if (lActivoFijo.size() > 0)
			for (int i = 0; i < lActivoFijo.size(); i++)
				lActivoFijoBO.add(lActivoFijo.get(i).toBO());
		else
			throw new NotFoundException("No se encontró ningún activo fijo con la fecha " + fechaCompra);

		return lActivoFijoBO;
	}

	@GetMapping("/obtener-activos-fijos-por-serial/{serial}")
	public List<ActivoFijoBO> obtenerActivosFijosPorSerial(@PathVariable String serial) {
		List<ActivoFijoBO> lActivoFijoBO = new ArrayList<>();
		List<ActivoFijo> lActivoFijo = activoFijoService.getActivosFijosBySerial(serial);

		if (lActivoFijo.size() > 0)
			for (int i = 0; i < lActivoFijo.size(); i++)
				lActivoFijoBO.add(lActivoFijo.get(i).toBO());
		else
			throw new NotFoundException("No se encontró ningún activo fijo asociado al serial " + serial);

		return lActivoFijoBO;
	}

	@PostMapping("/guardar-activo-fijo")
	public ActivoFijoBO crearActivoFijo(@RequestBody ActivoFijoBO activoFijoBO) {
		ActivoFijoBO rsActivoFijoBO = new ActivoFijoBO();

		if (activoFijoBO.getIdActivo() == null)
			rsActivoFijoBO = activoFijoService.insertActivoFijo(activoFijoBO);
		else
			rsActivoFijoBO = activoFijoService.updateActivoFijo(activoFijoBO);

		return rsActivoFijoBO;
	}
}
