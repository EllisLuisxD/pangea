package com.certus.spring.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import com.certus.spring.Dto.UsuarioRegistroDto;
import com.certus.spring.models.Usuario;

public interface UsuarioService extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDto registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}
