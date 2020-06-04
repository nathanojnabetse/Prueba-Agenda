/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaFinal.dao;

import com.pruebaFinal.modelo.Agenda;
import com.pruebaFinal.modelo.Contacto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author JONA
 */
public class AgendaContactosImpl implements IAgendaContacto
{
    private Connection conn;

    public AgendaContactosImpl() {
        if(conn==null){
            conn = ConexionJDBC.getConnection();
        }
    }
    
    private void closeConnection(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("No se puede cerrar la conexion a la bdd: "+ex.getMessage());
        }
    }

    @Override
    public List<Contacto> buscarContactosPorNombre(String nombre)
    {
        List<Contacto> contactos = new ArrayList<Contacto>();
        String sqlConsulta = "SELECT a.*, c.* FROM agenda a, contacto c WHERE a.nombrec = c.nombre and a.nombrec = ?;";
        contactos = ejecutarQuery(sqlConsulta,nombre);
        return contactos;
    }

    @Override
    public List<Contacto> listarDirectorio(String letra)
    {
        List<Contacto> contactos = new ArrayList<Contacto>();
        String sqlConsulta = "SELECT a.*, c.* FROM agenda a, contacto c WHERE c.nombre = a.nombrec and c.nombre like ?";
        contactos = ejecutarQuery(sqlConsulta,letra);
        return contactos;
    }

    @Override
    public List<Contacto> buscarContactosPorOcupacion(String ocupacion)
    {
        List<Contacto> contactos = new ArrayList<Contacto>();
        String sqlConsulta = "SELECT a.*, c.* FROM agenda a, contacto c where a.nombrec = c.nombre and c.ocupacion = ?";
        contactos = ejecutarQuery(sqlConsulta,ocupacion);
        return contactos;
    }

    @Override
    public List<Contacto> buscarContactosPorCumpleanos(Calendar cumpleanos)
    {
        List<Contacto> contactos = new ArrayList<Contacto>();
        String sqlConsulta = "SELECT a.*, c.* FROM agenda a, contacto c where a.nombrec = c.nombre and c.cumpleaños = ?";
        System.out.println(cumpleanos.getTime().getYear()+"-"+cumpleanos.getTime().getMonth()+"-"+cumpleanos.getTime().getDay());
        contactos = ejecutarQuery(sqlConsulta,cumpleanos.getTime().getYear()+"-"+cumpleanos.getTime().getMonth()+"-"+cumpleanos.getTime().getDay());
        return contactos;
    }

    @Override
    public List<Contacto> listarFavoritos()
    {
        List<Contacto> contactos = new ArrayList<Contacto>();
        String sqlConsulta = "SELECT a.*, c.* FROM agenda a, contacto c where a.nombrec = c.nombre and c.favorito= ?";
        contactos = ejecutarQuery(sqlConsulta,"1");
        return contactos;
    }

    @Override
    public void prueba()
    {
        String sqlConsulta = "SELECT * FROM contacto";// where favorito = ?;" ;
        PreparedStatement psNotas  = null;      
        try
        {
            psNotas = conn.prepareStatement(sqlConsulta);
            //psNotas.setString(1, "1");
            ResultSet rsNotas = psNotas.executeQuery();//devuelve un solo resultset m
            while(rsNotas.next())
            {
                boolean aprueba = (rsNotas.getByte("favorito")==1);
                System.out.println(aprueba);    
            } 
            psNotas.close();
        } 
        catch (SQLException ex)
        {
            System.err.println("No se pueden consultar el reporte de notas"+ex.getMessage());
        }
        finally
        {
            closeConnection();
        }
    }

    private List<Contacto> ejecutarQuery(String sqlNotas, String busqueda)
    {
        List<Contacto> contactos = new ArrayList<Contacto>();
        PreparedStatement psConsulta  = null;      
        try
        {
            System.out.println("1");
            psConsulta = conn.prepareStatement(sqlNotas);
            System.out.println("2");
            psConsulta.setString(1, busqueda);
            System.out.println("3");
            ResultSet rsConsulta = psConsulta.executeQuery();//devuelve un solo resultset m
            System.out.println("4");
            while(rsConsulta.next())
            {
                System.out.println("AAAA");
                String email = rsConsulta.getString("email");
                String celular = rsConsulta.getString("celular");
                String telefono = rsConsulta.getString("Telefono");
                String direccion = rsConsulta.getString("direccion");
                Agenda agenda = new Agenda(email, celular, telefono, direccion);
                
                String nombreq = rsConsulta.getString("nombre");
                String parentezco = rsConsulta.getString("parentezco");
                String ocupacion = rsConsulta.getString("ocupacion");
                java.sql.Date cumpleaños = rsConsulta.getDate("cumpleaños");
                Calendar cumpleObj = new GregorianCalendar(cumpleaños.getYear(),cumpleaños.getMonth(),cumpleaños.getDay());
                boolean favorito = (rsConsulta.getByte("favorito")==1);
                Contacto contacto = new Contacto(nombreq, parentezco, ocupacion, cumpleObj, favorito, agenda);
                
                contactos.add(contacto);
            } 
            psConsulta.close();
        } 
        catch (SQLException ex)
        {
            System.err.println("No se pueden consultar el reporte de notas "+ex.getMessage());
        }
        finally
        {
            closeConnection();
        }
        return contactos;
    }
}
