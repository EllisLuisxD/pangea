package com.certus.spring.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.certus.spring.models.CheckOut;
import java.util.List;


@Repository
public interface ICheckOutDao extends CrudRepository<CheckOut, Integer> {
	
	CheckOut findByNumTarjeta(String numTarjeta);
}
