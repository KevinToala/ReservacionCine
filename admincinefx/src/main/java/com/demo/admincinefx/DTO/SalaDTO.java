package com.demo.admincinefx.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SalaDTO {
	private Long id;
	private String nombre;
	private Integer filas;
	private Integer columnas;
	
	@JsonCreator
	public SalaDTO(
			@JsonProperty("id") Long id,
			@JsonProperty("nombre") String nombre,
			@JsonProperty("filas") Integer filas,
			@JsonProperty("columnas") Integer columnas)
	{
		this.id = id;
		this.nombre = nombre;
		this.filas = filas;
		this.columnas = columnas;
	}
	
	@Override
	public String toString(){
		return nombre;
	}
}
