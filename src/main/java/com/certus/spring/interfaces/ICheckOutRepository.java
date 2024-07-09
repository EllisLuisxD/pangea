package com.certus.spring.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.certus.spring.models.CheckOut;

@Repository
public interface ICheckOutRepository {
	
	@Autowired
	CheckOut obtenerTarjeta(String numTarjeta);
}
