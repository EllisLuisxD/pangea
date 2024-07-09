package com.certus.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.certus.spring.Dto.UsuarioRegistroDto;
import com.certus.spring.service.UsuarioService;

import jakarta.enterprise.inject.Model;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioController {

	private UsuarioService usuarioService;

	public RegistroUsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	@ModelAttribute("usuario")
	public UsuarioRegistroDto retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDto();
	}
	@GetMapping("/usuario")
	public String mostrarFormularioDeRegistro() {
		return "registroUsuario";
	}	
	@PostMapping("/usuario")
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDto registroDto) {
	    System.out.println("DTO recibido en el controlador: " + registroDto);
	    usuarioService.guardar(registroDto);
	    return "redirect:/registro/usuario?exito";
	}
	

	
}
