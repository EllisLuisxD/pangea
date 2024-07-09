package com.certus.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.certus.spring.models.ContactForm;


@Controller

public class contactFormController {
	@GetMapping("/contacto")
	public String mostrarFormularioContacto(Model model) {
	    model.addAttribute("contactForm", new ContactForm());
	    return "contacto"; // Esta es la vista que contiene el formulario
	}
}
