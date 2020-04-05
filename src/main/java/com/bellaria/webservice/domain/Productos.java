package com.bellaria.webservice.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos", schema="bellaria")
public class Productos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private float precioActual;
    private String URLImagenProducto;

    public Productos() {}

    public Productos(int id, String nombre, float precioactual, String URLImagenProducto) {
        this.id = id;
        this.nombre = nombre;
        this.precioActual = precioactual;
        this.URLImagenProducto = URLImagenProducto;
    }
    
    

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public float getPrecioActual() {return precioActual;}

    public void setPrecioActual(float precioActual) {this.precioActual = precioActual;}

    public String getURLImagenProducto() {return URLImagenProducto;}

    public void setURLImagenProducto(String URLImagenProducto) {this.URLImagenProducto = URLImagenProducto;}

   
}
