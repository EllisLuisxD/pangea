package com.certus.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pangea")
public class CompraExitosa {

	
	@GetMapping("/compraExitosa")
	public String pangea() {
		return "compraExitosa";
	}
}
