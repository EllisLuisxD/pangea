package com.certus.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pangea")
public class submitFormularioController {
	
    @GetMapping("/submitFormulario")
    public String mostrarResultadoFormulario() {
        return "submitFormulario"; // Devuelve el nombre de la vista personalizada
    }
}