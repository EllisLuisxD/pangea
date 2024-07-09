package com.certus.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.certus.spring.models.FormularioReserva;

@Controller
@RequestMapping("/pangea")
public class FormularioController {

    @PostMapping("/submitFormulario")
    public ModelAndView submitFormulario(@Valid @ModelAttribute FormularioReserva formulario, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            // Si hay errores de validación, volver al formulario con los errors
            modelAndView.setViewName("submitFormulario");
            modelAndView.addObject("error", "Error en la validación: " + result.getAllErrors().toString());
        } else {
            // Procesar los datos del formulario
            modelAndView.setViewName("submitSuccess");
            modelAndView.addObject("successMessage", "Formulario enviado con éxito");
        }

        return modelAndView;
    }
}