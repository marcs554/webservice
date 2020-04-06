package com.bellaria.webservice.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Marcos Rodríguez Breijo
 */
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

    /**
     * 
     * @param id Serial del producto.
     * @param nombre Nombre del producto.
     * @param precioactual Precio del producto
     * @param URLImagenProducto Imagen del producto en formato URL
     */
    public Productos(int id, String nombre, float precioactual, String URLImagenProducto) {
        this.id = id;
        this.nombre = nombre;
        this.precioActual = precioactual;
        this.URLImagenProducto = URLImagenProducto;
    }
    
    

    /**
     * 
     * @return Retorna el contenido del atributo id.
     */
    public int getId() {return id;}

    /**
     * 
     * @param id Establece/Modifica el atributo id.
     */
    public void setId(int id) {this.id = id;}

    /**
     * 
     * @return Retorna el contenido del atributo nombre.
     */
    public String getNombre() {return nombre;}

    /**
     * 
     * @param nombre Establece/Modifica el atributo nombre.
     */
    public void setNombre(String nombre) {this.nombre = nombre;}

    /**
     * 
     * @return Retorna el contenido del atributo precioActual.
     */
    public float getPrecioActual() {return precioActual;}

    /**
     * 
     * @param precioActual Establece/Modifica el atributo precioActual.
     */
    public void setPrecioActual(float precioActual) {this.precioActual = precioActual;}

    /**
     * 
     * @return Retorna el contenido del atributo URLImagenProducto.
     */
    public String getURLImagenProducto() {return URLImagenProducto;}

    /**
     * 
     * @param URLImagenProducto Establece/Modifica el atributo URLImagenProducto.
     */
    public void setURLImagenProducto(String URLImagenProducto) {this.URLImagenProducto = URLImagenProducto;}

   
}
