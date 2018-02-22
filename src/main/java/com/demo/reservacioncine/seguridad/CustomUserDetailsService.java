package com.demo.reservacioncine.seguridad;

import com.demo.reservacioncine.modelo.Usuario;
import com.demo.reservacioncine.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioRepositorio.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException(username);
		}
		
		return new User(username, user.getClave(), true, true, true, true, Arrays.asList());
	}
}
