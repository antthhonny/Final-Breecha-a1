/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Md_eventos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antho
 */
public class Conexion {
    
    String bd ="";
    String url ="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection ex;

    public Conexion() {
    }
    
    public Connection conectar (){
    try{
        Class.forName(driver);
        ex = DriverManager.getConnection(url + bd,user,password);
        System.out.println("se conecto correctamente ala base de datos: " + bd);
    }catch (ClassNotFoundException  |  SQLException ex){
        System.out.println("No se puede establecer conexion con la base de datos:" + bd);
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ex;
    }    
    
    public void  desconectar(){
    try {
        ex.close();
    }catch(SQLException ex){
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }         
    }
    
    public static void main (String[]arqs){
    Conexion conexion = new Conexion();
    conexion.conectar();
    } 
}

