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
    /**
     * 
     * @param id Serial del cliente.
     * @param nombreEmpresa Nombre de la empresa.
     * @param localizacion Localización de la empresa.
     * @param email Email de la empresa.
     * @param password Contraseña del usuario.
     */
    public Clientes(int id, String nombreEmpresa, String localizacion, String email, String password) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.localizacion = localizacion;
        this.email = email;
        this.password = password;
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
     * @return Retorna el contenido del atributo nombreEmpresa.
     */
    public String getNombreEmpresa() {return nombreEmpresa;}

    /**
     * 
     * @param nombreEmpresa Establece/Modifica el atributo nombreEmpresa.
     */
    public void setNombreEmpresa(String nombreEmpresa) {this.nombreEmpresa = nombreEmpresa;}

    /**
     * 
     * @return Retorna el contenido del atributo localizacion.
     */
    public String getLocalizacion() {return localizacion;}

    /**
     * 
     * @param localizacion Establece/Modifica el atributo localizacion.
     */
    public void setLocalizacion(String localizacion) {this.localizacion = localizacion;}

    /**
     * 
     * @return Retorna el contenido del atributo email.
     */
    public String getEmail() {return email;}

    /**
     * 
     * @param email Establece/Modifica el atributo email.
     */
    public void setEmail(String email) {this.email = email;}

    /**
     * 
     * @return Retorna el contenido del atributo password.
     */
    public String getPassword() {return password;}

    /**
     * 
     * @param password Establece/Modifica el atributo password.
     */
    public void setPassword(String password) {this.password = password;}

}
