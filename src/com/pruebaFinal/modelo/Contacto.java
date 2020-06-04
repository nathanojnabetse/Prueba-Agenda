/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaFinal.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author JONA
 */
public class Contacto
{

    private String nombre;
    private String parentezo;
    private String ocupación;
    private Calendar cumpleaños;
    private boolean favorito ;
    private Agenda agenda;
    
    public Contacto()
    {
    }

    public Contacto(String nombre, String parentezo, String ocupación, Calendar cumpleaños, boolean favorito, Agenda agenda)
    {
        this.nombre = nombre;
        this.parentezo = parentezo;
        this.ocupación = ocupación;
        this.cumpleaños = cumpleaños;
        this.favorito = favorito;
        this.agenda = agenda;
    } 
    
    public Agenda getAgenda()
    {
        return agenda;
    }

    public void setAgenda(Agenda agenda)
    {
        this.agenda = agenda;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getParentezo()
    {
        return parentezo;
    }

    public void setParentezo(String parentezo)
    {
        this.parentezo = parentezo;
    }

    public String getOcupación()
    {
        return ocupación;
    }

    public void setOcupación(String ocupación)
    {
        this.ocupación = ocupación;
    }

    public Calendar getCumpleaños()
    {
        return cumpleaños;
    }

    public void setCumpleaños(Calendar cumpleaños)
    {
        this.cumpleaños = cumpleaños;
    }

    public boolean isFavorito()
    {
        return favorito;
    }

    public void setFavorito(boolean favorito)
    {
        this.favorito = favorito;
    }
    
    @Override
    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Contacto{" + "nombre=" + nombre + ", parentezo=" + parentezo + ", ocupación=" + ocupación + 
                
                ", cumpleaños=" + sdf.format(cumpleaños.getTime()) + ", favorito=" + favorito + ", agenda=" + agenda + '}';
    }
}
