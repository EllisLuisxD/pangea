package com.certus.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class administradorLoginController {
	
	@GetMapping("/administradorLogin")
	public String administradorLogin() {
	 return "administradorLogin"; 
	}

}
