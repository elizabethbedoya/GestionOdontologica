/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sena.medi;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ADMIN
 */
public class conexion {
    Connection con;
    
    
    public  conexion(){
    
        try{
        
         Class.forName("com.mysql.cj.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost/citas","root","");
            System.out.println("Se ha conectado a la base de datos");
 
        }catch (Exception e){
        
            System.err.println("No se pudo conectar a la base de datos");
        
        
        }
       
    }

    public Connection getConnection(){
    return con;
    }
    
    
}
