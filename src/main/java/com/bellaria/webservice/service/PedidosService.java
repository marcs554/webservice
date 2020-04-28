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
     * @param id
     * @return Retorna una lista de pedidos que coincida con el email 
     */
    public List<Pedidos> listarPedidosCliente(int id) {
        return pedidosRepository.pedidosCliente(id);
    }

    /**
     * Si el cliente quiere realizar un pedido se pasará por parametros: la cantidad,
     * el importe, el id del cliente y el id del producto.Retornará una lista 
     * actualizada de los pedidos del cliente.
     * @param cantidad
     * @param importe
     * @param idCliente
     * @param idProducto
     * @return 
     */
    public List<Pedidos> realizarPedido(float cantidad, float importe, int idCliente, int idProducto) {
        pedidosRepository.nuevoPedido(cantidad, importe, idCliente, idProducto);
        return pedidosRepository.pedidosCliente(idCliente);

    }
    /**
     * Si el cliente quiere anular su pedido se cambiará el valor del campo
     * idestado para que su estado cambie a anulado, pasando como parametro el id 
     * del pedido. 
     * @param id
     */
    public void anularPedido(int id) {
       pedidosRepository.anularPedido(id);
    }
}
