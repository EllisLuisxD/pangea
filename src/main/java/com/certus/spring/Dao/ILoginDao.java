package com.certus.spring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.certus.spring.models.Login;
import com.certus.spring.models.Usuario;


@Repository
public interface ILoginDao extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    // Otros métodos de consulta según tus necesidades
}

