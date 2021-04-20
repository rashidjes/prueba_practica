package com.pruebapractica.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebapractica.api.entities.TipoActivo;

@Repository
public interface TipoActivoRepository extends JpaRepository<TipoActivo, Long> {
}
