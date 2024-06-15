package com.konecta.solicitudes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konecta.solicitudes.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
