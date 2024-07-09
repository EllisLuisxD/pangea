package com.certus.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pangea")
public class PromocionesController {
	
	@GetMapping("/promociones")
	public String promociones() {
    return "promociones"; // Devuelve el nombre de la vista personalizada
    }
}
