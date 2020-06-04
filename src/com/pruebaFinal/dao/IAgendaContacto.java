/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaFinal.dao;

import com.pruebaFinal.modelo.Contacto;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author JONA
 */
public interface IAgendaContacto
{
    public List<Contacto> buscarContactosPorNombre(String nombre);
    public List<Contacto> listarDirectorio(String letra);
    public List<Contacto> buscarContactosPorOcupacion(String ocupacion);
    public List<Contacto> buscarContactosPorCumpleanos(Calendar cumpleanos);
    public List<Contacto> listarFavoritos();
   
    public void prueba();

}
