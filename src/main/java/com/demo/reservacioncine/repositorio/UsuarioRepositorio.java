package com.demo.reservacioncine.repositorio;

import com.demo.reservacioncine.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
	Usuario findByUsername(String username);
}
