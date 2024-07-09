package com.certus.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.certus.spring.Dao.ICheckOutDao;
import com.certus.spring.interfaces.ICheckOutRepository;
import com.certus.spring.models.CheckOut;

@Repository
public class CheckOutRepository implements ICheckOutRepository{

	@Autowired
	private ICheckOutDao checkOutDao;
	
	@Override
	public CheckOut obtenerTarjeta(String numTarjeta) {
		
		return checkOutDao.findByNumTarjeta(numTarjeta);
	}
	
}
