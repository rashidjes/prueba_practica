package com.pruebapractica.api.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pruebapractica.api.entities.ActivoFijo;

@Repository
public interface ActivoFijoRepository extends JpaRepository<ActivoFijo, Long> {

	@Query("FROM ActivoFijo af WHERE af.tipoActivo.idTipoActivo = :idTipoActivo")
	List<ActivoFijo> findActivosFijosByTipoActivo(Long idTipoActivo);

	@Query("FROM ActivoFijo af WHERE DATE(af.fechaCompra) = DATE(:fechaCompra)")
	List<ActivoFijo> findActivosFijosByFechaCompra(Date fechaCompra);

	@Query("FROM ActivoFijo af WHERE af.serial = :serial")
	List<ActivoFijo> findActivosFijosBySerial(String serial);
}
