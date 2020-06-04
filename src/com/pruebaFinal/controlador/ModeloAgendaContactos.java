/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaFinal.controlador;

import com.pruebaFinal.modelo.Contacto;
import com.pruebaFinal.servicio.AgendaContacto;
import com.pruebaFinal.vista.AgendaJFrame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JONA
 */
public class ModeloAgendaContactos
{
    AgendaJFrame agenda = new AgendaJFrame();
    public List<Contacto> llenarTabla(int opcion, String busqueda)
    {
       List<Contacto> contactos = new ArrayList<>();
        if(opcion ==1)
        {
            contactos = AgendaContacto.buscarContactosPorNombre(busqueda);
            
        System.err.println("Se fue")    ;
        }
        else if(opcion == 2)
        {
           contactos = AgendaContacto.buscarContactosPorOcupacion(busqueda);
        }
        else if(opcion == 3)
        {
            try
            {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sdf.parse(busqueda);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                contactos = AgendaContacto.buscarContactosPorCumpleanos(cal);
    //            for(Contacto ct : AgendaContacto.buscarContactosPorCumpleanos(cal))
    //            {
    //                System.out.println(ct);
    //            }
            } catch (ParseException ex)
            {
                System.err.println("No se puede convertir la fecha: "+ ex.getMessage());
            }
        }
        else if(opcion == 4)
        {
            contactos = AgendaContacto.listarDirectorio(busqueda+"%");
        }
        else if(opcion == 5)
        {
            contactos = AgendaContacto.listarFavoritos();
        }
        
        return contactos;
    }
    
}
