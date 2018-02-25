package com.demo.reservacioncine.controlador;

import com.demo.reservacioncine.modelo.Butaca;
import com.demo.reservacioncine.modelo.Funcion;
import com.demo.reservacioncine.modelo.Sala;
import com.demo.reservacioncine.repositorio.ButacaRepositorio;
import com.demo.reservacioncine.repositorio.FuncionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ButacaControlador {
	@Autowired private ButacaRepositorio butacaRepositorio;
	@Autowired private FuncionRepositorio funcionRepositorio;
	
	@GetMapping("funciones/{idFuncion}/butacas")
	public Butaca[][] listaButacas(@PathVariable Long idFuncion){
		Funcion funcion = funcionRepositorio.findOne(idFuncion);
		Sala sala = funcion.getSala();
		
		Butaca[][] butacas = new Butaca[sala.getFilas()][sala.getColumnas()];
		funcion.getButacas().forEach(butaca -> {
			if(butaca.getReserva() != null){
				butaca.getReserva().setButacas(null);
				butaca.getReserva().getUsuario().setReservas(null);
				butaca.getReserva().setFuncion(null);
			}
			
			butaca.setFuncion(null);
			
			butacas[butaca.getFila()-1][butaca.getColumna()-1] = butaca;
		});
		
		return butacas;
	}
}
