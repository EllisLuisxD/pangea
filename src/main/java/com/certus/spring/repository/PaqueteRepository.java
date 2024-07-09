package com.certus.spring.repository;

import com.certus.spring.models.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Long> {
    List<Paquete> findAllByOrderByFechaCreacionDesc();
}