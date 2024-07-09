package com.certus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certus.spring.interfaces.ICheckOutRepository;
import com.certus.spring.models.CheckOut;

@Service
public class CheckOutService implements ICheckOutService{
	
	@Autowired
	public ICheckOutRepository checkOutRepository;

	@Override
	public String obtenerTarjeta(CheckOut numTarjeta) {
		
		String vistaDefinitiva = "checkout";
		
		CheckOut _tarjeta = checkOutRepository.obtenerTarjeta(numTarjeta.getNumTarjeta());
		
		if (_tarjeta !=null) {
			if (numTarjeta.getCvv().equals(_tarjeta.getCvv())) {
				vistaDefinitiva = "compraExitosa";
			}
		}else {
			return vistaDefinitiva;
		}
		
		return vistaDefinitiva;
	}

}
