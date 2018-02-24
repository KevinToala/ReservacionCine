package com.demo.reservacioncine.repositorio;

import com.demo.reservacioncine.modelo.Sala;
import org.springframework.data.repository.CrudRepository;

public interface SalaRepositorio extends CrudRepository<Sala, Long> {
}
