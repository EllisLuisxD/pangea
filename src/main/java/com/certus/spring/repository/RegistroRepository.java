package com.certus.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.certus.spring.models.Usuario;

public interface RegistroRepository extends JpaRepository<Usuario, Long>{

}
