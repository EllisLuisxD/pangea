package com.certus.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogueadosController {

	@GetMapping("/nosotrosLogueado")
	public String nosotrosLogueado() {
		return "nosotrosLogueado";
	}
	
	@GetMapping("/contactoLogueado")
	public String contactoLogueado() {
		return "contactoLogueado";
	}
	
	@GetMapping("/cartLogueado")
	public String cartLogueado() {
		return "cartLogueado";
	}
}
