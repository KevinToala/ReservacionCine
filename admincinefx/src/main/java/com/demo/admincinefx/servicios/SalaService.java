package com.demo.admincinefx.servicios;

import com.demo.admincinefx.DTO.SalaDTO;
import com.demo.admincinefx.servicios.base.ServicioBase;
import javafx.concurrent.Task;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class SalaService extends ServicioBase {
	
	public Task<Collection<SalaDTO>> obtenerSalas(){
		return new Task<Collection<SalaDTO>>() {
			@Override
			protected Collection<SalaDTO> call(){
				SalaDTO[] salas = restTemplate.getForObject("http://localhost:8080/salas", SalaDTO[].class);
				return Arrays.asList(salas);
			}
		};
	}
}
