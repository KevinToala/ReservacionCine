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
	private @Lob String descripcion;
	private long duracion; //En minutos
	private String urlImagen;
	
	@Enumerated(EnumType.STRING)
	private GeneroPelicula genero;
	
	@OneToMany(mappedBy = "pelicula", fetch = FetchType.EAGER)
	private List<Funcion> funciones;
}
