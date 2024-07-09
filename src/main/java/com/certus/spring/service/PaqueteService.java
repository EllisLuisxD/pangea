package com.certus.spring.service;

import com.certus.spring.models.Paquete;
import com.certus.spring.repository.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaqueteService {

    @Autowired
    private PaqueteRepository paqueteRepository;

    public List<Paquete> obtenerTodosLosPaquetes() {
        return paqueteRepository.findAll();
    }

    public Paquete obtenerPaquetePorId(Long id) {
        Optional<Paquete> paquete = paqueteRepository.findById(id);
        return paquete.orElse(null);
    }

    public Paquete guardarPaquete(Paquete paquete) {
        return paqueteRepository.save(paquete);
    }

    public List<Paquete> obtenerPaquetesOrdenados() {
        return paqueteRepository.findAllByOrderByFechaCreacionDesc();
    }

    public void eliminarPaquete(Long id) {
        paqueteRepository.deleteById(id);
    }
}
