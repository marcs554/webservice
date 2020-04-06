package com.bellaria.webservice.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Marcos Rodríguez Breijo
 */
@Entity
@Table(name="estado", schema="bellaria")
public class Estado implements Serializable {

    @Id
    private int id;
    private String nombreEstado;

    /**
     * 
     * @param idEstado id del estado
     * @param nombreEstado nombre del estado
     */
    public Estado(int idEstado, String nombreEstado) {
        this.id = idEstado;
        this.nombreEstado = nombreEstado;
    }

    public Estado() {}
    
    /**
     * 
     * @return Retorna el contenido del atributo id
     */
    public int getId() { return id; }

    /**
     * 
     * @return Retorna el contenido del atributo nombreEstado
     */
    public String getNombreEstado() { return nombreEstado; }
    
    
}
