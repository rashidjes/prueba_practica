package com.pruebapractica.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebapractica.api.entities.TipoActivo;
import com.pruebapractica.api.repositories.TipoActivoRepository;

@Service
public class TipoActivoServiceImpl implements TipoActivoService {

	@Autowired
	private TipoActivoRepository tipoActivoRepository;

	@Override
	public List<TipoActivo> getAllTiposActivos() {
		return tipoActivoRepository.findAll();
	}

}
