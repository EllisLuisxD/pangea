package com.certus.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.certus.spring.models.Administrador;
import com.certus.spring.models.CheckOut;
import com.certus.spring.service.IAdministradorService;

@Controller
@RequestMapping("/pangea")
public class AdministradorController{
	
	@Autowired
	private IAdministradorService administradorService;

	@GetMapping("/Administrador")
	public String registroAdministrador(Model model) {
		Administrador administrador = new Administrador();
		
		model.addAttribute("administrador",administrador);
		
		return "Administrador/login";
	}
	
	@PostMapping("/logueo")
	public String registroAdministrador(Administrador name, Model model) {
		
		Administrador newAdministrador = new Administrador();
		
		model.addAttribute("administrador",newAdministrador);
		
		return administradorService.obtenerAdministrador(newAdministrador);
	}	
}
