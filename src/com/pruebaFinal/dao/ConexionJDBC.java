/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaFinal.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

/**
 *
 * @author CEC
 */
public class ConexionJDBC {
    private static final String CONEXIONES="C:\\Users\\JONA\\Documents\\JAVA CEC\\Prueba Final\\resorces\\conexiones.xml"; 
    private static DatosConexion dc;
    public static Connection conn;

    public ConexionJDBC() {
        if(dc == null){
            obtenerDatosConexion();
        }
    }
    
    
    
    public static Connection getConnection(){
        try {
            if(dc == null){
                obtenerDatosConexion();
            }
            Class.forName(dc.getDriver()).newInstance();
            conn = DriverManager.getConnection(dc.getUrl(), dc.getUsuario(), dc.getClave());
            //System.out.println(dc.toString());
        } catch (Exception ex) {
            System.out.println("No se pudo generar la conexion: "+ex.getMessage());
        }
        return conn;
    }
    
    private static void obtenerDatosConexion(){
        FileReader fr = null;
        BufferedReader br = null;
        String linea = null;
        String contenidoXML="";
        boolean conexionActiva = false;
        try {
            fr = new FileReader(CONEXIONES);
            br = new BufferedReader(fr);
            while((linea = br.readLine())!=null){
                contenidoXML += "\n"+linea; 
            }
            Document doc = DocumentHelper.parseText(contenidoXML);
            List<Node> nodosConexion = doc.selectNodes("/conexiones/conexion");
            for (Node nodo : nodosConexion) {
                conexionActiva = Boolean.parseBoolean( nodo.selectSingleNode("activa").getText() );
                if(conexionActiva){
                    
                    dc = new DatosConexion(
                            nodo.selectSingleNode("esquema").getText(), 
                            nodo.selectSingleNode("usuario").getText(), 
                            nodo.selectSingleNode("clave").getText(), 
                            nodo.selectSingleNode("driver").getText(), 
                            nodo.selectSingleNode("url").getText());
                    break;
                }
            }            
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo "+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo "+ex.getMessage());
        } catch (DocumentException ex) {
            System.out.println("No se pudo parsear informacion de conexiones "+ex.getMessage());
        } finally {
            try {
                fr.close();
                br.close();
            } catch (IOException ex) {
            }
        }
    }
}
