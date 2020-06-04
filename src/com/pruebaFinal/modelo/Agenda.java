/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaFinal.modelo;

/**
 *
 * @author JONA
 */
public class Agenda
{
    private String email;
    private String celular;
    private String telefono;
    private String dirección;

    public Agenda()
    {
    }

    public Agenda(String email, String celular, String telefono, String dirección)
    {
        this.email = email;
        this.celular = celular;
        this.telefono = telefono;
        this.dirección = dirección;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getCelular()
    {
        return celular;
    }

    public void setCelular(String celular)
    {
        this.celular = celular;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public String getDirección()
    {
        return dirección;
    }

    public void setDirección(String dirección)
    {
        this.dirección = dirección;
    }
    
    @Override
    public String toString()
    {
        return "\n\tAgenda{" + "email=" + email + ", celular=" + celular + ", telefono=" + telefono + ", direcci\u00f3n=" + dirección + '}';
    }

}
