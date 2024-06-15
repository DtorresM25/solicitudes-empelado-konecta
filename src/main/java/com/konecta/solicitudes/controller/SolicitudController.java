package com.konecta.solicitudes.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konecta.solicitudes.model.Solicitud;
import com.konecta.solicitudes.service.SolicitudService;

@RestController
@RequestMapping("/solicitud/")
public class SolicitudController {

	@Autowired
	private SolicitudService solicitudService;

	@GetMapping
	private ResponseEntity<List<Solicitud>> getAllSolicitud() {
		return ResponseEntity.ok(solicitudService.findAll());
	}

	@PostMapping
	private ResponseEntity<Solicitud> saveSolicitud(@RequestBody Solicitud solicitud) {
		Solicitud guardarSolicitud = solicitudService.save(solicitud);
		try {
			return ResponseEntity.created(new URI("/solictud/" + guardarSolicitud.getEmpleado().getNombre()))
					.body(guardarSolicitud);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).build();
		}
	}
}
