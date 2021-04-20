package com.pruebapractica.api.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebapractica.api.dtos.ActivoFijoBO;
import com.pruebapractica.api.entities.ActivoFijo;
import com.pruebapractica.api.entities.TipoActivo;
import com.pruebapractica.api.entities.TipoAsignacion;
import com.pruebapractica.api.repositories.ActivoFijoRepository;

@Service
public class ActivoFijoServiceImpl implements ActivoFijoService {

	@Autowired
	private ActivoFijoRepository activoFijoRepository;

	@Override
	public Optional<ActivoFijo> getActivoFijoByIdActivo(Long idActivo) {
		return activoFijoRepository.findById(idActivo);
	}

	@Override
	public List<ActivoFijo> getActivosFijosByTipoActivo(Long idTipoActivo) {
		return activoFijoRepository.findActivosFijosByTipoActivo(idTipoActivo);
	}

	@Override
	public List<ActivoFijo> getActivosFijosByFechaCompra(Date fechaCompra) {
		return activoFijoRepository.findActivosFijosByFechaCompra(fechaCompra);
	}

	@Override
	public List<ActivoFijo> getActivosFijosBySerial(String serial) {
		return activoFijoRepository.findActivosFijosBySerial(serial);
	}

	@Override
	@Transactional
	public ActivoFijoBO insertActivoFijo(ActivoFijoBO activoFijoBO) {
		// Recuperar los datos desde el dto
		ActivoFijo activoFijo = new ActivoFijo();

		activoFijo.setNombre(activoFijoBO.getNombre());
		activoFijo.setDescripcion(activoFijoBO.getDescripcion().getBytes());

		// Recuperar del dto TipoActivoBO
		TipoActivo tipoActivo = new TipoActivo();
		if (activoFijoBO.getTipoActivoBO() != null && activoFijoBO.getTipoActivoBO().getIdTipoActivo() != null) {
			tipoActivo.setIdTipoActivo(activoFijoBO.getTipoActivoBO().getIdTipoActivo());
		} else {
			// Exception porque no existe TipoActivoBO
			System.out.println("Exception porque no existe TipoActivoBO");
		}
		activoFijo.setTipoActivo(tipoActivo);

		activoFijo.setSerial(activoFijoBO.getSerial());
		activoFijo.setNumeroInterno(activoFijoBO.getNumeroInterno());
		activoFijo.setPeso(activoFijoBO.getPeso());
		activoFijo.setAlto(activoFijoBO.getAlto());
		activoFijo.setAncho(activoFijoBO.getAncho());
		activoFijo.setLargo(activoFijoBO.getLargo());
		activoFijo.setValorCompra(activoFijoBO.getValorCompra());
		activoFijo.setFechaCompra(activoFijoBO.getFechaCompra());
		activoFijo.setEstado(1);

		// Recuperar del dto TipoAsignacionBO
		TipoAsignacion tipoAsignacion = new TipoAsignacion();
		tipoAsignacion.setIdTipoAsignacion(1L);
		activoFijo.setTipoAsignacion(tipoAsignacion);

		// Insertar y devolver dto
		return activoFijoRepository.save(activoFijo).toBO();
	}

	@Override
	@Transactional
	public ActivoFijoBO updateActivoFijo(ActivoFijoBO activoFijoBO) {
		// Recuperar los datos desde el dto
		ActivoFijo activoFijo = new ActivoFijo();

		Optional<ActivoFijo> optActivoFijo = activoFijoRepository.findById(activoFijoBO.getIdActivo());

		if (optActivoFijo.isPresent()) {
			activoFijo.setIdActivo(activoFijoBO.getIdActivo());
			activoFijo.setNombre(
					activoFijoBO.getNombre() != null ? activoFijoBO.getNombre() : optActivoFijo.get().getNombre());
			activoFijo.setDescripcion(activoFijoBO.getDescripcion() != null ? activoFijoBO.getDescripcion().getBytes()
					: optActivoFijo.get().getDescripcion());

			// Recuperar del dto TipoActivoBO
			TipoActivo tipoActivo = new TipoActivo();
			if (activoFijoBO.getTipoActivoBO() != null && activoFijoBO.getTipoActivoBO().getIdTipoActivo() != null) {
				tipoActivo.setIdTipoActivo(activoFijoBO.getTipoActivoBO().getIdTipoActivo());
			} else {
				tipoActivo.setIdTipoActivo(optActivoFijo.get().getTipoActivo().getIdTipoActivo());
			}
			activoFijo.setTipoActivo(tipoActivo);

			activoFijo.setSerial(
					activoFijoBO.getSerial() != null ? activoFijoBO.getSerial() : optActivoFijo.get().getSerial());
			activoFijo.setNumeroInterno(activoFijoBO.getNumeroInterno() > 0 ? activoFijoBO.getNumeroInterno()
					: optActivoFijo.get().getNumeroInterno());
			activoFijo.setPeso(activoFijoBO.getPeso() > 0 ? activoFijoBO.getPeso() : optActivoFijo.get().getPeso());
			activoFijo.setAlto(activoFijoBO.getAlto() > 0 ? activoFijoBO.getAlto() : optActivoFijo.get().getAlto());
			activoFijo.setAncho(activoFijoBO.getAncho() > 0 ? activoFijoBO.getAncho() : optActivoFijo.get().getAncho());
			activoFijo.setLargo(activoFijoBO.getLargo() > 0 ? activoFijoBO.getLargo() : optActivoFijo.get().getLargo());
			activoFijo.setValorCompra(activoFijoBO.getValorCompra() != null ? activoFijoBO.getValorCompra()
					: optActivoFijo.get().getValorCompra());
			activoFijo.setFechaCompra(optActivoFijo.get().getFechaCompra());
			activoFijo.setEstado(
					activoFijoBO.getEstado() > 0 ? activoFijoBO.getEstado() : optActivoFijo.get().getEstado());

			// Recuperar del dto TipoAsignacionBO
			TipoAsignacion tipoAsignacion = new TipoAsignacion();
			if (activoFijoBO.getTipoAsignacionBO() != null
					&& activoFijoBO.getTipoAsignacionBO().getIdTipoAsignacion() != null) {
				tipoAsignacion.setIdTipoAsignacion(activoFijoBO.getTipoAsignacionBO().getIdTipoAsignacion());
			} else {
				tipoAsignacion.setIdTipoAsignacion(optActivoFijo.get().getTipoAsignacion().getIdTipoAsignacion());
			}
			activoFijo.setTipoAsignacion(tipoAsignacion);
		} else {
			// Exception porque no existe el activo fijo
			System.out.println("Exception porque no existe el activo fijo");
		}

		// Actualizar y devolver dto
		return activoFijoRepository.save(activoFijo).toBO();
	}

}
