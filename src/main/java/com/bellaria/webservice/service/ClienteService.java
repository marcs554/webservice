package com.bellaria.webservice.service;

import com.bellaria.webservice.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Comprueba si el el email y la contraseña del cliente son correctos 
     * ---------------------------------------------------------------
     * @param userEmail
     * @param password
     * @return 
     */
    public boolean loginCliente(String userEmail, String password) {
        if (clienteRepository.findByEmailAndPassword(userEmail, password).size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Registra una nueva cuenta de usuario
     * -----------------------------------------------
     * @param nombreEmpresa
     * @param localidad
     * @param email
     * @param password
     * @return 
     */
    public boolean addNewCliente(String nombreEmpresa, String localidad, String email, String password) {
        if (clienteRepository.findByNombreEmpresaAndEmail(nombreEmpresa, email).isEmpty()) {
            clienteRepository.addNewCliente(nombreEmpresa, localidad, email, password);
            return true;
        } else {
            return false;
        }

    }
}
