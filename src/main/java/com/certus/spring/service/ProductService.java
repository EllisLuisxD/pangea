package com.certus.spring.service;

import org.springframework.stereotype.Service;

import com.certus.spring.models.Product;

@Service
public class ProductService {

    // Simula la búsqueda de un producto por ID
    public Product findById(Long id) {
    	
        // Aquí debes implementar la lógica para encontrar un producto por su ID
        // Por ejemplo, puedes buscar en una base de datos
        return new Product();
    }
}