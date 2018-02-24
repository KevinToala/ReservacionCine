package com.demo.reservacioncine.repositorio;

import com.demo.reservacioncine.modelo.Reserva;
import org.springframework.data.repository.CrudRepository;

public interface ReservaRepositorio extends CrudRepository<Reserva, Long> {
}
