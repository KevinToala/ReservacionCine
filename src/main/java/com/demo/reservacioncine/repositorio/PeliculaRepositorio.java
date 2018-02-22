package com.demo.reservacioncine.repositorio;

import com.demo.reservacioncine.modelo.Pelicula;
import org.springframework.data.repository.CrudRepository;

public interface PeliculaRepositorio extends CrudRepository<Pelicula, Long> {
}
