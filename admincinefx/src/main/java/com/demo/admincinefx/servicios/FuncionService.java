package com.demo.admincinefx.servicios;

import com.demo.admincinefx.DTO.FuncionDTO;
import com.demo.admincinefx.servicios.base.ServicioBase;
import javafx.concurrent.Task;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
public class FuncionService extends ServicioBase {
	
	public Task<Collection<FuncionDTO>> obtenerFunciones(){
		return new Task<Collection<FuncionDTO>>() {
			@Override
			protected Collection<FuncionDTO> call(){
				FuncionDTO[] funciones = restTemplate.getForObject("http://localhost:8080/funciones", FuncionDTO[].class);
				return Arrays.asList(funciones);
			}
		};
	}
	
	public Task<FuncionDTO> guardar(FuncionDTO funcion){
		return new Task<FuncionDTO>() {
			@Override
			protected FuncionDTO call(){
				return restTemplate.postForObject("http://localhost:8080/funciones", funcion, FuncionDTO.class);
			}
		};
	}
}
