package com.demo.reservacioncine.controlador;

import com.demo.reservacioncine.modelo.Butaca;
import com.demo.reservacioncine.modelo.Funcion;
import com.demo.reservacioncine.modelo.Reserva;
import com.demo.reservacioncine.modelo.Usuario;
import com.demo.reservacioncine.repositorio.ButacaRepositorio;
import com.demo.reservacioncine.repositorio.FuncionRepositorio;
import com.demo.reservacioncine.repositorio.ReservaRepositorio;
import com.demo.reservacioncine.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservaControlador {
	@Autowired private ReservaRepositorio reservaRepositorio;
	@Autowired private UsuarioRepositorio usuarioRepositorio;
	@Autowired private FuncionRepositorio funcionRepositorio;
	@Autowired private ButacaRepositorio butacaRepositorio;
	
	@PostMapping("reservas")
	public Reserva crearReserva(@RequestBody Reserva reserva){
		Usuario usuario = usuarioRepositorio.findOne(reserva.getId());
		Funcion funcion = funcionRepositorio.findOne(reserva.getFuncion().getId());
		
		reserva.setUsuario(usuario);
		reserva.setFuncion(funcion);
		reservaRepositorio.save(reserva);
		
		reserva.getIdButacasReservar().forEach(idButaca -> {
			Butaca butaca = butacaRepositorio.findOne(idButaca);
			butaca.setReserva(reserva);
			butacaRepositorio.save(butaca);
		});
		
		return reserva;
	}
}
