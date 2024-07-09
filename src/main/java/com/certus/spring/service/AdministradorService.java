package com.certus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certus.spring.models.Administrador;
import com.certus.spring.repository.IAdministradorRepository;

@Service
public class AdministradorService implements IAdministradorService{
	
	@Autowired
	public IAdministradorRepository administradorRepository;

	@Override
	public String obtenerAdministrador(Administrador name) {
		
		String vistaDefinitiva = "Administrador/login";
		
		Administrador _administrador = administradorRepository.obtenerAdministrador(name.getName());
		
		if (_administrador !=null) {
			if (name.getPassword().equals(_administrador.getPassword())) {
				vistaDefinitiva = "/Administrador/dashboard";
			}
		}else {
			return vistaDefinitiva;
		}
		
		return vistaDefinitiva;
	}

}
