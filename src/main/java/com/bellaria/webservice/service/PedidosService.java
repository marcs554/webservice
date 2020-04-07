package com.bellaria.webservice.service;

import com.bellaria.webservice.domain.Pedidos;
import com.bellaria.webservice.repository.PedidosRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Marcos Rodríguez Breijo
 */
@Service
public class PedidosService {

    private final PedidosRepository pedidosRepository;

    public PedidosService(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }

    /**
     * Lista todos los pedidos del cliente pasando por parametro el email 
     * del usuario.
     * @param email
     * @return Retorna una lista de pedidos que coincida con el email 
     */
    public List<Pedidos> listarPedidosCliente(String email) {
        return pedidosRepository.pedidosCliente(email);
    }

    /**
     * Si el cliente quiere realizar un pedido se pasará por parametros: la cantidad,
     * el importe, el id del cliente y el id del producto. Retornará un valor booleano, (true)
     * si se añadió una fila nueva en la tabla pedidos, (false) si no se añadió ninguna fila 
     * en la tabla pedidos.
     * @param cantidad
     * @param importe
     * @param idCliente
     * @param idProducto
     * @return
     */
    public boolean realizarPedido(int cantidad, float importe, int idCliente, int idProducto) {
        if (pedidosRepository.nuevoPedido(cantidad, importe, idCliente, idProducto) > 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Si el cliente quiere anular su pedido se cambiará el valor del campo
     * idestado para que su estado cambie a anulado, pasando como parametro el id 
     * del pedido. Retornará un valor booleano, (true) si se modificó la fila
     * en la tabla pedidos, (false) si no se modificó ninguna fila en la tabla pedidos.
     * @param id
     * @return
     */
    public boolean anularPedido(int id) {
        if(pedidosRepository.anularPedido(id) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
