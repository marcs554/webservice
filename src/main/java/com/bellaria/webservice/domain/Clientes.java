package com.bellaria.webservice.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes", schema="bellaria")
public class Clientes implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEmpresa;
    private String localizacion;
    private String email;
    private String password;

    public Clientes() {}

    public Clientes(int id, String nombre, String localizacion, String email, String password) {
        this.id = id;
        this.nombreEmpresa = nombre;
        this.localizacion = localizacion;
        this.email = email;
        this.password = password;
    }
    

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNombreEmpresa() {return nombreEmpresa;}

    public void setNombreEmpresa(String nombreEmpresa) {this.nombreEmpresa = nombreEmpresa;}

    public String getLocalizacion() {return localizacion;}

    public void setLocalizacion(String localizacion) {this.localizacion = localizacion;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

}
