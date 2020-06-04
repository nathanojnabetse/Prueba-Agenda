/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaFinal.servicio;

import com.pruebaFinal.dao.AgendaContactosImpl;
import com.pruebaFinal.modelo.Contacto;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author JONA
 */
public class AgendaContacto
{
    public static List<Contacto> buscarContactosPorNombre(String nombre)
    {
        return new AgendaContactosImpl().buscarContactosPorNombre(nombre);
    }
    public static List<Contacto> listarDirectorio(String letra)
    {
        return new AgendaContactosImpl().listarDirectorio(letra);
    }
    public static List<Contacto> buscarContactosPorOcupacion(String ocupacion)
    {
        return new AgendaContactosImpl().buscarContactosPorOcupacion(ocupacion);
    }
    public static List<Contacto> buscarContactosPorCumpleanos(Calendar cumpleanos)
    {
        return new AgendaContactosImpl().buscarContactosPorCumpleanos(cumpleanos);
    }
    public static List<Contacto> listarFavoritos()
    {
        return new AgendaContactosImpl().listarFavoritos();
    }
    
    public static void prueba()
    {
        new AgendaContactosImpl().prueba();
    }
}
