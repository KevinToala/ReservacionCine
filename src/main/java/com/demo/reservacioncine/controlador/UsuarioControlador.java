package com.demo.reservacioncine.controlador;

import com.demo.reservacioncine.modelo.Rol;
import com.demo.reservacioncine.modelo.Usuario;
import com.demo.reservacioncine.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UsuarioControlador {
	@Autowired private UsuarioRepositorio usuarioRepositorio;
	@Autowired private PasswordEncoder encoder;
	
	@PostMapping("login")
	public Usuario login(Principal principal){
		Usuario usuario = usuarioRepositorio.findByUsername(principal.getName());
		usuario.setReservas(null);
		return usuario;
	}
	
	@PostMapping("usuarios")
	public Usuario crearUsuario(@RequestBody Usuario usuario){
		usuario.setUsername(usuario.getUsername().toLowerCase());
		usuario.setRol(Rol.CLIENTE);
		usuario.setClave(encoder.encode(usuario.getClave()));
		return usuarioRepositorio.save(usuario);
	}
}
/*
 * Crear Funciones
 * Crear Reserva
 */
