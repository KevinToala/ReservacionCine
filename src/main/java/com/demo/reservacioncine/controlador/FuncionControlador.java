package com.demo.reservacioncine.controlador;

import com.demo.reservacioncine.modelo.Butaca;
import com.demo.reservacioncine.modelo.Funcion;
import com.demo.reservacioncine.modelo.Pelicula;
import com.demo.reservacioncine.modelo.Sala;
import com.demo.reservacioncine.repositorio.ButacaRepositorio;
import com.demo.reservacioncine.repositorio.FuncionRepositorio;
import com.demo.reservacioncine.repositorio.PeliculaRepositorio;
import com.demo.reservacioncine.repositorio.SalaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FuncionControlador {
	@Autowired private PeliculaRepositorio peliculaRepositorio;
	@Autowired private FuncionRepositorio funcionRepositorio;
	@Autowired private SalaRepositorio salaRepositorio;
	@Autowired private ButacaRepositorio butacaRepositorio;
	
	@GetMapping("/funciones")
	public Iterable<Funcion> obtenerTodasLasFunciones(){
		return funcionRepositorio.findAll();
	}
	
	@GetMapping("/peliculas/{idPelicula}/funciones")
	public List<Funcion> listaFunciones(@PathVariable Long idPelicula){
		Pelicula pelicula = peliculaRepositorio.findOne(idPelicula);
		return pelicula.getFunciones();
	}
	
	@PostMapping("/funciones")
	public Funcion crearFuncion(@RequestBody Funcion funcion){
		Sala sala = salaRepositorio.findOne(funcion.getSala().getId());
		Pelicula pelicula = peliculaRepositorio.findOne(funcion.getPelicula().getId());
		
		funcion.setSala(sala);
		funcion.setPelicula(pelicula);
		
		funcionRepositorio.save(funcion);
		
		for(int fila = 0; fila < sala.getFilas(); fila++){
			for(int columna = 0; columna < sala.getColumnas(); columna++){
				Butaca butaca = new Butaca();
				butaca.setFuncion(funcion);
				butaca.setColumna(columna +1);
				butaca.setFila(fila + 1);
				butacaRepositorio.save(butaca);
			}
		}
		
		return funcionRepositorio.save(funcion);
	}
}
