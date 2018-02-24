package com.demo.reservacioncine.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "funciones")
@Getter @Setter
@NoArgsConstructor
public class Funcion extends ModeloBase {
	@ManyToOne
	@JoinColumn(nullable = false)
	private Sala sala;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pelicula pelicula;
	
	private LocalDate fecha;
	private LocalTime horario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "funcion")
	private List<Butaca> butacas;
	
	@JsonIgnore
	@OneToMany(mappedBy = "funcion")
	private List<Reserva> reservas;
}
