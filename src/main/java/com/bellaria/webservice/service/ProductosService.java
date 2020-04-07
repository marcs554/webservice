package com.bellaria.webservice.service;

import com.bellaria.webservice.domain.Productos;
import com.bellaria.webservice.repository.ProductosRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Marcos Rodríguez Breijo
 */
@Service
public class ProductosService {

    private final ProductosRepository productosRepository;

    public ProductosService(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    /**
     * Lista todos los productos disponibles en la base de datos
     * @return Retorna una lista con todos los productos de la tabla productos.
     */
    public List<Productos> listarProductos() {

        return productosRepository.findAll();
    }
}
