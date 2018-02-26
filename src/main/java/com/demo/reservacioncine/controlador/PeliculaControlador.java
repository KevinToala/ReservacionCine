package com.demo.reservacioncine.controlador;

import com.demo.reservacioncine.modelo.Pelicula;
import com.demo.reservacioncine.repositorio.PeliculaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("peliculas")
public class PeliculaControlador {
	@Autowired
	private PeliculaRepositorio peliculaRepositorio;
	
	@GetMapping
	public Iterable<Pelicula> obtenerPeliculas(){
		return peliculaRepositorio.findAll();
	}
	
	@PostMapping
	public Pelicula crearPelicula(@RequestBody Pelicula pelicula){
		return peliculaRepositorio.save(pelicula);
	}
}
