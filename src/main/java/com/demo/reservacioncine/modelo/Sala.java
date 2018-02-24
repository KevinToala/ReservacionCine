package com.demo.reservacioncine.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "salas")
@Getter @Setter
@NoArgsConstructor
public class Sala extends ModeloBase {
	private String nombre;
	private int filas;
	private int columnas;
}
