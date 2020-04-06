package com.bellaria.webservice.controller;

import com.bellaria.webservice.domain.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bellaria.webservice.service.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class controlador {

    private final ClienteService clienteService;
    private final PedidosService pedidosService;
    private final ProductosService productosService;

    public controlador(ClienteService clienteService, PedidosService pedidosService, ProductosService productosService) {
        this.clienteService = clienteService;
        this.pedidosService = pedidosService;
        this.productosService = productosService;
    }

    /**
     * Cuando el usuario quiera iniciar sesión con la app accederá a este enlace 
     * que a su vez hara la llamada a la función pasando por parametros el email 
     * y el password
     * ----------------------------------------------------------------------------
     * @param email
     * @param password
     * @return 
    */
    @GetMapping("/login")
    public boolean login(@RequestParam("email") String email, @RequestParam("password") String password) {
        System.out.println(clienteService.loginCliente(email, password));
        return clienteService.loginCliente(email, password);
    }
    
    /**
     * Cuando el cliente quiera listar todos sus pedidos la app llamará a este
     * enlace que a su vez hara la llamada a la función
     * --------------------------------------------------------------
     * @return 
    */
    @RequestMapping("/productos")
    public List<Productos> getAllProductos() {
        List<Productos> listarProductos = productosService.listarProductos();
        
        return listarProductos;
    }
    
    /**
     * Cuando el cliente quiera listar todos sus pedidos la app llamará a este
     * enlace que a su vez hara la llamada a la función recibiendo por parametro 
     * el email
     * --------------------------------------------------------------------------
     * @param email
     * @return 
     */
     
    @GetMapping("/pedidoscliente")
    public List<Pedidos> getPedidosCliente(@RequestParam("email") String email) {
        return pedidosService.listarPedidosCliente(email);
    }
    
    /**
     * Se hará la llamada a este enlace que a su vez hara la llamda a la función 
     * cuando el usuario quiera crearse una cuenta nueva
     * ------------------------------------------------------------------------------
     * @param nombre
     * @param localizacion
     * @param email
     * @param password
     * @return 
    */
    @GetMapping("/nuevousuario")
    public boolean signUp(@RequestParam("nombre") String nombre, @RequestParam("localizacion") String localizacion,
            @RequestParam("email") String email, @RequestParam("password") String password){
        return clienteService.addNewCliente(nombre, localizacion, email, password);
    }
    
    /**
     * Se hará la llamada a este enlace que a su vez hara la llamada a la función 
     * cuando el usuario quiera realizar un nuevo pedido
     * -----------------------------------------------------------------------
     * @param cantidad
     * @param importe
     * @param idCliente
     * @param idProducto
     * @return 
    */
    @GetMapping("/nuevopedido")
    public int realizarPedido(@RequestParam("cantidad") int cantidad, @RequestParam("importe") float importe, 
            @RequestParam("idcliente") int idCliente, @RequestParam("idproducto") int idProducto) {
        return pedidosService.realizarPedido(cantidad, importe, idCliente, idProducto);
    }
    
    /**
     * Cuando el usuario quiera anular uno de sus pedidos la app hara la llamada
     * a este enlace que a su vez hara la llamada a la función
     * --------------------------------------------------------------------------
     * @param id
     * @return 
    */
    @GetMapping("/anularpedido")
    public int anularPedido(@RequestParam("id") int id) {
        return pedidosService.anularPedido(id);
    }
}
