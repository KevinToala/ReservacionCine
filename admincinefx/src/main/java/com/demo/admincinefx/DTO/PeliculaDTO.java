package com.demo.admincinefx.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static org.apache.commons.lang.StringUtils.trimToNull;

@Getter @Setter
@NoArgsConstructor
public class PeliculaDTO {
	private Long id;
	private String titulo;
	private String descripcion;
	private Long duracion;
	private String urlImagen;
	private String genero;
	
	@JsonCreator
	public PeliculaDTO(
		@JsonProperty("id") Long id,
		@JsonProperty("titulo") String titulo,
		@JsonProperty("descripcion") String descripcion,
		@JsonProperty("duracion") Long duracion,
		@JsonProperty("urlImagen") String urlImagen,
		@JsonProperty("genero") String genero)
	{
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.urlImagen = urlImagen;
		this.genero = genero;
	}
	
	public boolean esValido(){
		return trimToNull(titulo) != null &&
				trimToNull(descripcion) != null &&
				trimToNull(urlImagen) != null &&
				trimToNull(genero) != null &&
				duracion != null &&
				duracion > 0;
	}
	
	@Override
	public String toString(){
		return titulo;
	}
}
