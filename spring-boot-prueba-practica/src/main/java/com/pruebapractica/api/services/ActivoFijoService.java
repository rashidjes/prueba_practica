package com.pruebapractica.api.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.pruebapractica.api.dtos.ActivoFijoBO;
import com.pruebapractica.api.entities.ActivoFijo;

public interface ActivoFijoService {

	List<ActivoFijo> getActivosFijosByTipoActivo(Long idTipoActivo);

	List<ActivoFijo> getActivosFijosByFechaCompra(Date fechaCompra);

	List<ActivoFijo> getActivosFijosBySerial(String serial);

	ActivoFijoBO insertActivoFijo(ActivoFijoBO activoFijoBO);

	ActivoFijoBO updateActivoFijo(ActivoFijoBO activoFijoBO);

	Optional<ActivoFijo> getActivoFijoByIdActivo(Long idActivo);
}
