package com.bellaria.webservice.repository;

import com.bellaria.webservice.domain.Clientes;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Clientes, Integer> {

    /**
     * Retorna una lista de los clientes que están almacenados en la base de datos
     * que coincidan con los parametros: userEmail y password.
     * ------------------------------------------------------------------------------
     * @param userEmail
     * @param password
     * @return 
     */
    List<Clientes> findByEmailAndPassword(String userEmail, String password);

    /**
     * Inserta una nueva fila en la tabla clientes.
     * --------------------------------------------------------
     * @param nombre
     * @param localizacion
     * @param email
     * @param password 
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO clientes (nombre_empresa, localizacion, email, password) VALUES (?1,?2,?3,?4)", nativeQuery = true)
    void addNewCliente(String nombre, String localizacion, String email, String password);

    /**
     * Retorna una lista de los usuario que están almacenados en la base de datos
     * que coincidan con los parametros: nombre y email.
     * ---------------------------------------------------------------------------
     * @param nombre
     * @param email
     * @return 
     */
    List<Clientes> findByNombreEmpresaAndEmail(String nombre, String email);

}
