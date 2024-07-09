package com.certus.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.certus.spring.models.Administrador;

@Repository
public interface IAdministradorRepository {
	@Autowired
	Administrador obtenerAdministrador(String name);
}
