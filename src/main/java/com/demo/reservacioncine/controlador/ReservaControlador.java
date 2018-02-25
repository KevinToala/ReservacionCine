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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ReservaControlador {
	@Autowired private ReservaRepositorio reservaRepositorio;
	@Autowired private UsuarioRepositorio usuarioRepositorio;
	@Autowired private FuncionRepositorio funcionRepositorio;
	@Autowired private ButacaRepositorio butacaRepositorio;
	
	@PostMapping("reservas")
	public ResponseEntity<Void> crearReserva(@RequestBody Reserva reserva){
		Usuario usuario = usuarioRepositorio.findOne(reserva.getUsuario().getId());
		Funcion funcion = funcionRepositorio.findOne(reserva.getFuncion().getId());
		
		reserva.setUsuario(usuario);
		reserva.setFuncion(funcion);
		reserva.setFecha(LocalDateTime.now());
		reservaRepositorio.save(reserva);
		
		reserva.getIdButacasReservar().forEach(idButaca -> {
			Butaca butaca = butacaRepositorio.findOne(idButaca);
			butaca.setReserva(reserva);
			butacaRepositorio.save(butaca);
		});
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("usuarios/{idUsuario}/reservas")
	public List<Reserva> obtenerReservas(@PathVariable Long idUsuario){
		Usuario usuario = usuarioRepositorio.findOne(idUsuario);
		List<Reserva> reservas = usuario.getReservas();
		reservas.forEach(reserva -> {
			reserva.getFuncion().setButacas(null);
			reserva.getFuncion().setReservas(null);
			reserva.getFuncion().getPelicula().setFunciones(null);
			reserva.getUsuario().setReservas(null);
			reserva.getButacas().forEach(butaca -> {
				butaca.setReserva(null);
				butaca.setFuncion(null);
			});
		});
		return reservas;
	}
}
