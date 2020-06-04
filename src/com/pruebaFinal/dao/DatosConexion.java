/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaFinal.dao;

/**
 *
 * @author CEC
 */
public class DatosConexion {

    @Override
    public String toString()
    {
        return "DatosConexion{" + "esquema=" + esquema + ", usuario=" + usuario + ", clave=" + clave + ", driver=" + driver + ", url=" + url + '}';
    }
    private String esquema;
    private String usuario;
    private String clave;
    private String driver;
    private String url;


    public String getEsquema() {
        return esquema;
    }

    public void setEsquema(String esquema) {
        this.esquema = esquema;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DatosConexion(String esquema, String usuario, String clave, String driver, String url) {
        this.esquema = esquema;
        this.usuario = usuario;
        this.clave = clave;
        this.driver = driver;
        this.url = url;
    }
}
