package com.demo.admincinefx.servicios;

import com.demo.admincinefx.DTO.PeliculaDTO;
import com.demo.admincinefx.servicios.base.ServicioBase;
import javafx.concurrent.Task;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
public class PeliculaServicio extends ServicioBase {
	public Task<Collection<PeliculaDTO>> obtenerPeliculas(){
		return new Task<Collection<PeliculaDTO>>() {
			@Override
			protected Collection<PeliculaDTO> call(){
				PeliculaDTO[] peliculas = restTemplate.getForObject("http://localhost:8080/peliculas", PeliculaDTO[].class);
				return Arrays.asList(peliculas);
			}
		};
	}
	
	public Task<PeliculaDTO> guardar(PeliculaDTO pelicula){
		return new Task<PeliculaDTO>() {
			@Override
			protected PeliculaDTO call(){
				return restTemplate.postForObject("http://localhost:8080/peliculas", pelicula, PeliculaDTO.class);
			}
		};
	}
}
