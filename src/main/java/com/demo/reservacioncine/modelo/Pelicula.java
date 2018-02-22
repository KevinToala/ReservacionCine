package com.demo.reservacioncine.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "peliculas")
@Getter @Setter
@NoArgsConstructor
public class Pelicula extends ModeloBase {
	private String titulo;
	private String descripcion;
	private long duracion; //En segundos
	
	@Enumerated(EnumType.STRING)
	private GeneroPelicula genero;
	
	@OneToMany(mappedBy = "pelicula")
	private List<Funcion> funciones;
}
