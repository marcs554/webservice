package com.bellaria.webservice.controller;

import com.bellaria.webservice.domain.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bellaria.webservice.service.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author Marcos Rodríguez Breijo
 */
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
     * Indice de página.
     * @return 
     */
    @RequestMapping("/")
    public String index(){
        return "Bellaria";
    }
    /**
     * Cuando el usuario quiera iniciar sesión con la app accederá a este enlace 
     * que a su vez hará la llamada a la función pasando por parametros el email 
     * y el password.
     * @param email Ingresa el email del usuario.
     * @param password Ingresa la contraseña del usuario.
     * @return Retorna un json con toda la información del cliente.
    */
    @GetMapping("/login")
    public List<Clientes> login(@RequestParam("email") String email, @RequestParam("password") String password) {
        return clienteService.loginCliente(email, password);
    }
    
    /**
     * Cuando el usuario quiera listar todos sus pedidos la app llamará a este
     * enlace que a su vez hará la llamada a la función.
     * @return Retorna un json de productos almacenada en la base de datos.
    */
    @RequestMapping("/productos")
    public List<Productos> getAllProductos() {
        List<Productos> listarProductos = productosService.listarProductos();
        
        return listarProductos;
    }
    
    /**
     * Cuando el cliente quiera listar todos sus pedidos la app llamará a este
     * enlace que a su vez hará la llamada a la función recibiendo por parametro 
     * el email.
     * @param idCliente
     * @return Retorna un json de pedidos del usuario de la base de datos a traves del campo idCliente.
     */
     
    @GetMapping("/pedidoscliente")
    public List<Pedidos> getPedidosCliente(@RequestParam("idcliente") int idCliente) {
        return pedidosService.listarPedidosCliente(idCliente);
    }
    
    /**
     * Cuando el usuario se registre por primera vez la app irá a este enlace para 
     * almacenar los campos: nombre, localización, email, password.
     * @param nombre Ingresa el nombre de la empresa.
     * @param localizacion Ingresa la localización de la empresa .
     * @param email Ingresa el email del usuario.
     * @param password Ingresa la contraseña del usuario.
     * @return Retorna un valor boolean confirmando si se creó la cuenta con exito (true) o no (false).
    */
    @PostMapping("/nuevousuario")
    public List<Clientes> registrarse(@RequestParam("nombre") String nombre, @RequestParam("localizacion") String localizacion,
            @RequestParam("email") String email, @RequestParam("password") String password){
        return clienteService.addNewCliente(nombre, localizacion, email, password);
    }
    
    /**
     * Se hará la llamada a este enlace que a su vez hara la llamada a la función 
     * cuando el usuario quiera realizar un nuevo pedido.
     * @param cantidad Ingresa la cantidad (en KGs).
     * @param importe Ingresa el importe total: cantidad * precioActual.
     * @param idCliente Ingresa el id del cliente el cual hace el pedido.
     * @param idProducto Ingresa el id del producto el se quiere adquirir.
     * @return 
    */
    @PostMapping("/nuevopedido")
    public List<Pedidos> realizarPedido(@RequestParam("cantidad") float cantidad, @RequestParam("importe") float importe, 
            @RequestParam("idcliente") int idCliente, @RequestParam("idproducto") int idProducto) {
        pedidosService.realizarPedido(cantidad, importe, idCliente, idProducto);
        
        return pedidosService.listarPedidosCliente(idCliente);
    }
    
    /**
     * Cuando el usuario quiera anular uno de sus pedidos la app hara la llamada
     * a este enlace que a su vez hara la llamada a la función
     * @param idPedido Ingresa el id del pedido..
     * @return 
    */
    @PatchMapping("/anularpedido")
    public List<Pedidos> anularPedido(@RequestParam("idpedido") int idPedido) {
        pedidosService.anularPedido(idPedido);
        return pedidosService.listarPedidosCliente(idPedido);
    }
}
