package com.konecta.solicitudes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konecta.solicitudes.model.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {

}
