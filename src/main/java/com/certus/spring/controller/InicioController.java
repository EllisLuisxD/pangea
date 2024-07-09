package com.certus.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {

	
	@GetMapping({"/","/home"})
	public String pangea() {
		return "inicio";
	}
}
