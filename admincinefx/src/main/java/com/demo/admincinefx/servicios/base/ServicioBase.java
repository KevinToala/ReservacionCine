package com.demo.admincinefx.servicios.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public abstract class ServicioBase {
	@Autowired
	protected RestTemplate restTemplate;
}
