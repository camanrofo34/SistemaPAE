/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Acciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Personal
 */
public class EstablecerConexión {
    public Connection conectar() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://DESKTOP-M3DKATA\\SQLEXPRESS:1433;databaseName=PAE;user=userSQL;password=1097096174;";
        Connection con = DriverManager.getConnection(connectionURL);
        return con;
    }
    
    }
