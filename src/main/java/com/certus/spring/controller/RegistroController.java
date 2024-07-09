package com.certus.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.certus.spring.service.UsuarioService;


@Controller
public class RegistroController {

	@Autowired
	private UsuarioService servicio;
	
	@GetMapping("/loginUsuario")
	public String iniciarSesion() {
		return "loginUsuario";
	}
	
	
	@GetMapping("/inicioLogueado")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return "inicioLogueado";
	}
}
