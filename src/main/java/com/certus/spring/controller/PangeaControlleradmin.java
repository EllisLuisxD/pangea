package com.certus.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PangeaControlleradmin {
	
	@GetMapping("/dashboard")
	public String inicio() {
		return "/Administrador/dashboard";
	}

	
	@GetMapping("/usuarios")
	public String usuarios() {
		return "Administrador/controlusuarios/usuarios";
	}
	
	@GetMapping("/edit")
	public String editusuarios() {
		return "Administrador/controlusuarios/editusuarios";
	}
	
	@GetMapping("/add")
	public String addusuarios() {
		return "Administrador/controlusuarios/addusuarios";
	}
	
	@GetMapping("/addpaquete")
	public String addpaquete() {
		return "/Administrador/controlpaquetes/addpaquete.html";
	}
	
	@GetMapping("/activo")
	public String actpaquete() {
		return "/Administrador/controlpaquetes/actpaquete.html";
	}
	
	@GetMapping("/pendiente")
	public String penpaquete() {
		return "/Administrador/controlpaquetes/penpaquete.html";
	}
	
	@GetMapping("/expirado")
	public String exppaquete() {
		return "/Administrador/controlpaquetes/exppaquete.html";
	}
	
	/*
	 * @GetMapping("/login") public String login() { return
	 * "/Administrador/login.html"; }
	 */
	
	@GetMapping("/reestablecerContra")
	public String reestablecerContra() {
		return "/Administrador/reestablecerContra.html";
	}
	
	@GetMapping("/enviadoExito")
	public String enviadoExito() {
		return "/Administrador/enviadoExito.html";
	}
	
}