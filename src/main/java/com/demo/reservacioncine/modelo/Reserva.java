package com.demo.reservacioncine.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

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
	
	private LocalDate fecha;
}
