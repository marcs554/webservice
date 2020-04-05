package com.bellaria.webservice.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedidos", schema="bellaria")
public class Pedidos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fechaPedido;
    private int cantidad;
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

    public Pedidos(int id, String fechapedido, int cantidad, float importe, Clientes cliente, Productos productos, Estado estado) {
        this.id = id;
        this.fechaPedido = fechapedido;
        this.cantidad = cantidad;
        this.importe = importe;
        this.cliente = cliente;
        this.productos = productos;
        this.estado = estado;
    }

    
    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getFechaPedido() {return fechaPedido;}

    public void setFechaPedido(String fechaPedido) {this.fechaPedido = fechaPedido;}

    public int getCantidad() {return cantidad;}

    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

    public Clientes getCliente() {return cliente;}

    public void setCliente(Clientes cliente) {this.cliente = cliente;}

    public Productos getProductos() {return productos;}

    public void setProductos(Productos productos) {this.productos = productos;}

    public Estado getEstado() {return estado;}

    public void setEstado(Estado estado) {this.estado = estado;}

    public float getImporte() {return importe;}

    public void setImporte(float importe) {this.importe = importe;}

    
    
}
