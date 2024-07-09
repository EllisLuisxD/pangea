package com.certus.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; // Importar la anotación @PostMapping
import org.springframework.web.bind.annotation.RequestMapping;
import com.certus.spring.models.ContactForm;

@Controller
@RequestMapping("/pangea")
public class ContactoController {

    @GetMapping("/contacto")
    public String mostrarFormularioContacto(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contacto";
    }

    @PostMapping("/contactFormController") // Método para manejar las solicitudes POST del formulario
    public String procesarFormulario(ContactForm contactForm) {
        // Aquí procesas los datos del formulario, por ejemplo, guardarlos en la base de datos

        // Después puedes redirigir a otra página de éxito o renderizar una vista de éxito
        return "exito"; // asumiendo que existe una vista llamada "exito.html"
    }
}



