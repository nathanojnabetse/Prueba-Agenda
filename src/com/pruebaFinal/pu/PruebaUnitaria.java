/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaFinal.pu;

import com.pruebaFinal.modelo.Contacto;
import com.pruebaFinal.servicio.AgendaContacto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JONA
 */
public class PruebaUnitaria
{
    public static void main(String[] args)
    {
        List<Contacto> contactos = new ArrayList<>();
//        //PRUEBA 1
//    contactos = AgendaContacto.buscarContactosPorNombre("Jonathan Jaramillo");
//        //PRUEBA 2
//    contactos = AgendaContacto.listarDirectorio("D%");
//        //PRUEBA 3
//    contactos = AgendaContacto.buscarContactosPorOcupacion("Estudiante");
//        //PRUEBA 4
//    try
//    {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf.parse("1997-06-04");
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        contactos = AgendaContacto.buscarContactosPorCumpleanos(cal);
//
//    } catch (ParseException ex)
//    {
//        Logger.getLogger(PruebaUnitaria.class.getName()).log(Level.SEVERE, null, ex);
//    }
    //PRUEBA 5
    contactos = AgendaContacto.listarFavoritos();
            
    //COMPROBAR EL RETORNO
    for(Contacto ct : contactos)
        {
            System.out.println(ct);
        }
    }
}
