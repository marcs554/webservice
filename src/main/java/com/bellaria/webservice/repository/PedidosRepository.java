package com.bellaria.webservice.repository;

import com.bellaria.webservice.domain.Pedidos;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {

    /**
     * Retorna una lista de pedidos de la tabla pedidos de la base de datos
     * que coincida con el parametro: email.
     * ---------------------------------------------------------------------
     * @param email
     * @return 
     */
    @Query("from Pedidos as p join fetch p.cliente where p.cliente.email = ?1")
    List<Pedidos> pedidosCliente(String email);

    /**
     * Inserta una nueva fila en la tabla pedidos
     * --------------------------------------------------------
     * @param cantidad
     * @param importe
     * @param idCliente
     * @param idProducto
     * @return 
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO pedidos (NOW(), cantidad, importe, idcliente, idproducto, idestado)"
            + "VALUES(?1,?2,?3,?4,?5,1)", nativeQuery = true)
    int nuevoPedido(int cantidad, float importe, int idCliente, int idProducto);

    /**
     * Cambia el valor del campo idestado de la tabla pedidos a 5 'Anulado'
     * ----------------------------------------------------------------------
     * @param id
     * @return 
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE pedidos SET idestado = 5 where id = ?1", nativeQuery = true)
    int anularPedido(int id);
}
