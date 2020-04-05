package com.bellaria.webservice.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado", schema="bellaria")
public class Estado implements Serializable {

    @Id
    private int id;
    private String nombreEstado;

    public Estado(int idEstado, String nombreEstado) {
        this.id = idEstado;
        this.nombreEstado = nombreEstado;
    }

    public Estado() {}
    
    
    public int getId() { return id; }

    public String getNombreEstado() { return nombreEstado; }
    
    
}
