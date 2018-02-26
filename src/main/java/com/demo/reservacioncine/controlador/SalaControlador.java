package com.demo.reservacioncine.controlador;

import com.demo.reservacioncine.modelo.Sala;
import com.demo.reservacioncine.repositorio.SalaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalaControlador {
	@Autowired
	private SalaRepositorio salaRepositorio;
	
	@GetMapping("/salas")
	public Iterable<Sala> obtenerSalas(){
		return salaRepositorio.findAll();
	}
}
