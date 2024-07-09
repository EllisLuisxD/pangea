package com.certus.spring.service;

import org.springframework.stereotype.Service;

import com.certus.spring.models.CheckOut;

@Service
public interface ICheckOutService {
	
	public String obtenerTarjeta(CheckOut numTarjeta);
}
