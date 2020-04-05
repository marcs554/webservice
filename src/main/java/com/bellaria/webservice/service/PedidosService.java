package com.bellaria.webservice.service;

import com.bellaria.webservice.domain.Pedidos;
import com.bellaria.webservice.repository.PedidosRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PedidosService {

    private final PedidosRepository pedidosRepository;

    public PedidosService(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }

    /**
     * Lista todos los pedidos del cliente pasando por parametro el email 
     * del usuario.
     * -------------------------------------------------------------------
     * @param email
     * @return 
     */
    public List<Pedidos> listarPedidosCliente(String email) {
        return pedidosRepository.pedidosCliente(email);
    }

    /**
     * Si el cliente quiere realizar un pedido se pasará por parametros: la cantidad,
     * el importe, el id del cliente y el id del producto.
     * -------------------------------------------------------------------------------
     * @param cantidad
     * @param importe
     * @param idCliente
     * @param idProducto
     * @return 
     */
    public int realizarPedido(int cantidad, float importe, int idCliente, int idProducto) {
        return pedidosRepository.nuevoPedido(cantidad, importe, idCliente, idProducto);
    }

    /**
     * Si el cliente quiere anular su pedido se cambiará el valor del campo
     * idestado para que su estado cambie a anulado, pasando como parametro el id 
     * del pedido
     * -----------------------------------------------------------------------------
     * @param id
     * @return 
     */
    public int anularPedido(int id) {
        return pedidosRepository.anularPedido(id);
    }
}
