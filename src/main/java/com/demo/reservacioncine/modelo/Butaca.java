package com.demo.reservacioncine.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "butacas")
@Getter @Setter
@NoArgsConstructor
public class Butaca extends ModeloBase {
	@ManyToOne
	@JoinColumn(nullable = false)
	private Funcion funcion;
	
	@ManyToOne
	@JoinColumn(nullable = true)
	private Reserva reserva;
	private int fila;
	private int columna;
}
