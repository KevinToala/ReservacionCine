package com.demo.reservacioncine.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Getter @Setter
@NoArgsConstructor
public class Usuario extends ModeloBase {
	private String username;
	private String clave;
	private String nombres;
	private String apellidos;
	private String identificacion;
	private LocalDate fechaNacimiento;
	
	@Enumerated(EnumType.STRING)
	private Rol rol;
}
