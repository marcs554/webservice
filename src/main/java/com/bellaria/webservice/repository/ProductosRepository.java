package com.bellaria.webservice.repository;

import com.bellaria.webservice.domain.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Marcos Rodríguez Breijo
 */
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
}
