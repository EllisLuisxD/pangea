package com.certus.spring.Dao;

import org.springframework.data.repository.CrudRepository;

import com.certus.spring.models.Administrador;

public interface IAdministradorDao extends CrudRepository<Administrador, Integer>{
	Administrador findByName(String name);
}
