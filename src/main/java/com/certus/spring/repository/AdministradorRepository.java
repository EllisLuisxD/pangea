package com.certus.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.certus.spring.Dao.IAdministradorDao;
import com.certus.spring.models.Administrador;

@Repository
public class AdministradorRepository implements IAdministradorRepository{

	@Autowired
	private IAdministradorDao administradorDao;
	
	@Override
	public Administrador obtenerAdministrador(String name) {
		
		return administradorDao.findByName(name);
	}
	
}
