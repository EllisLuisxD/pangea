package com.certus.spring.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.certus.spring.models.Usuario;


@Repository
public interface ILoginRepository {

	@Autowired
	Usuario loadUserByUsername(String username);
}
