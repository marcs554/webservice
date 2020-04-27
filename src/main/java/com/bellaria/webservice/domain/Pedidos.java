package com.bellaria.webservice.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Marcos Rodríguez Breijo
 */
@Entity
@Table(name="pedidos", schema="bellaria")
public class Pedidos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fechaPedido;
    private float cantidad;
    private float importe;
    @ManyToOne
    @JoinColumn(name="idcliente", nullable=false)
    private Clientes cliente;
    @ManyToOne
    @JoinColumn(name="idproducto", nullable=false)
    private Productos productos;
    @ManyToOne
    @JoinColumn(name="idestado", nullable=false)
    private Estado estado;
    
    public Pedidos() {}

    /**
     * 
     * @param id Serial del pedido.
     * @param fechapedido Fecha en la que se hizo el pedido.
     * @param cantidad Cantidad del producto seleccionado (KG).
     * @param importe Total del pedido (cantidad * precioActual).
     * @param cliente El cliente que realizó el pedido.
     * @param productos El producto seleccionado.
     * @param estado El estado del pedido.
     */
    public Pedidos(int id, String fechapedido, int cantidad, float importe, Clientes cliente, Productos productos, Estado estado) {
        this.id = id;
        this.fechaPedido = fechapedido;
        this.cantidad = cantidad;
        this.importe = importe;
        this.cliente = cliente;
        this.productos = productos;
        this.estado = estado;
    }

    /**
     * 
     * @return Retorna el contenido del atributo serial.
     */
    public int getId() {return id;}

    /**
     * 
     * @param id Establece/Modifica el atributo serial.
     */
    public void setId(int id) {this.id = id;}

    /**
     * 
     * @return Retorna el contenido del atributo fechaPedido.
     */
    public String getFechaPedido() {return fechaPedido;}
    
    /**
     * 
     * @param fechaPedido Establece/Modifica el atributo fechaPedido.
     */
    public void setFechaPedido(String fechaPedido) {this.fechaPedido = fechaPedido;}

    /**
     * 
     * @return Retorna el contenido del atributo cantidad.
     */
    public float getCantidad() {return cantidad;}

    /**
     * 
     * @param cantidad Establece/Modifica el atributo cantidad.
     */
    public void setCantidad(float cantidad) {this.cantidad = cantidad;}

    /**
     * 
     * @return Retorna el contenido del atributo importe.
     */
    public float getImporte() {return importe;}

    /**
     * 
     * @param importe Establece/Modifica el contenido del atributo importe.
     */
    public void setImporte(float importe) {this.importe = importe;}

    /**
     * 
     * @return Retorna el contenido del atributo cliente.
     */
    
    public Clientes getCliente() {return cliente;}

    /**
     * 
     * @param cliente Establece/Modifica el atributo cliente.
     */
    public void setCliente(Clientes cliente) {this.cliente = cliente;}

    /**
     * 
     * @return Retorna el contenido del atributo productos.
     */
    public Productos getProductos() {return productos;}

    /**
     * 
     * @param productos Establece/Modifica el atributo productos.
     */
    public void setProductos(Productos productos) {this.productos = productos;}

    /**
     * 
     * @return Retorna el contenido del atributo estado.
     */
    public Estado getEstado() {return estado;}

    /**
     * 
     * @param estado Establece/Modifica el contenido del atributo estado.
     */
    public void setEstado(Estado estado) {this.estado = estado;}

}
