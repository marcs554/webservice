package com.bellaria.webservice.repository;

import com.bellaria.webservice.domain.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    /**
     * Retorno de todos los productos de la tabla productos
     */
}
