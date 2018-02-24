package com.demo.reservacioncine.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "reservas")
@Getter @Setter
@NoArgsConstructor
public class Reserva extends ModeloBase {
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Funcion funcion;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;
	
	private LocalDateTime fecha;
	
	@Transient
	private Set<Long> idButacasReservar;
}
