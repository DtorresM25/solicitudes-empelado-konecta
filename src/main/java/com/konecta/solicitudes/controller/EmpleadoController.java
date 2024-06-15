package com.konecta.solicitudes.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konecta.solicitudes.model.Empleado;
import com.konecta.solicitudes.service.EmpleadoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/empleado/")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping()
	private ResponseEntity<List<Empleado>> getAllSolicitud() {
		return ResponseEntity.ok(empleadoService.findAll());
	}

	@PostMapping
	private ResponseEntity<Empleado> saveSolicitud(@RequestBody Empleado empleado) {
		Empleado guardarEmpleado = empleadoService.save(empleado);
		try {
			return ResponseEntity.created(new URI("/solictud/" + guardarEmpleado.getNombre())).body(guardarEmpleado);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).build();
		}
	}
	
}
