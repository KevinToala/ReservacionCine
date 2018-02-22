package com.demo.reservacioncine.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@Getter @Setter
@NoArgsConstructor

@MappedSuperclass
public class ModeloBase {
	
	@Id
	@GeneratedValue
	private Long id;
}