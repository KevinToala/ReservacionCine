package com.demo.reservacioncine.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	
	@JsonIgnore
	@OneToMany(mappedBy = "pelicula")
	private List<Funcion> funciones;
}
