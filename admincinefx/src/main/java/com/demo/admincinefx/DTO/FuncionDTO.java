package com.demo.admincinefx.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang.StringUtils.trimToNull;

@Getter
@Setter
@NoArgsConstructor
public class FuncionDTO {
	private Long id;
	private SalaDTO sala;
	private PeliculaDTO pelicula;
	private String fecha;
	private String horario;
	
	@JsonCreator
	public FuncionDTO(
			@JsonProperty("id") Long id,
			@JsonProperty("sala") SalaDTO sala,
			@JsonProperty("pelicula") PeliculaDTO pelicula,
			@JsonProperty("fecha") String fecha,
			@JsonProperty("horario") String horario)
	{
		this.id = id;
		this.sala = sala;
		this.pelicula = pelicula;
		this.fecha = fecha;
		this.horario = horario;
	}
	
	public boolean esValido(){
		Pattern p = Pattern.compile("[0-9]{2}:[0-9]{2}");

		return sala != null &&
				pelicula != null &&
				trimToNull(fecha) != null &&
				trimToNull(horario) != null &&
				p.matcher(horario).find();
	}
}
