/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Acciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Personal
 */
public class RegistroDAO {
    public int RegistrarInst(String Nombre, String Dep, String Ciudad, int Numero, String tel, String correo) throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    String connectionURL = "jdbc:sqlserver://DESKTOP-M3DKATA\\SQLEXPRESS:1433;databaseName=PAE;user=userSQL;password=1097096174;";
    Connection con = DriverManager.getConnection(connectionURL);
    
    // Prepara para insertar los datos en la base de datos y obtener el ID generado
    String sql1 = "insert into Insituciones(NombreInstitución, Departamento, Municipio, NumeroEstudiantes, TeléfonoContacto, CorreoInstitucional) values(?,?,?,?,?,?)";
    PreparedStatement ps = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS); 
    
    // Se ingresan los datos en la base de datos
    ps.setString(1, Nombre);
    ps.setString(2, Dep);
    ps.setString(3, Ciudad);
    ps.setInt(4, Numero);
    ps.setString(5, tel);
    ps.setString(6, correo);
    
    // Ejecuta la inserción y obtén el ID generado
    int affectedRows = ps.executeUpdate();
    int generatedId = -1;  // Valor predeterminado en caso de que no se genere un ID
    
    if (affectedRows > 0) {
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            generatedId = generatedKeys.getInt(1);  // Obtiene el ID generado
        }
    }
    
    // Cierra la conexión y muestra el mensaje
    con.close();
    JOptionPane.showMessageDialog(null, "Datos agregados a la base de datos. ID generado: " + generatedId);
    
    return generatedId; 
    }
    public void Editar(int id, String dep, String ciudad, int numero, String tel, String correo) throws ClassNotFoundException, SQLException {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    String connectionURL = "jdbc:sqlserver://DESKTOP-M3DKATA\\SQLEXPRESS:1433;databaseName=PAE;user=userSQL;password=1097096174;";
    Connection con = DriverManager.getConnection(connectionURL);
    
    // Verifica si la institución con el ID proporcionado existe en la base de datos
    String selectSql = "SELECT * FROM Insituciones WHERE ID = ?";
    PreparedStatement selectPs = con.prepareStatement(selectSql);
    selectPs.setInt(1, id);
    ResultSet resultSet = selectPs.executeQuery();
    
    if (resultSet.next()) {
        // Si la institución existe, actualiza sus detalles (excepto nombre, departamento y municipio)
        String updateSql = "UPDATE Insituciones SET NumeroEstudiantes = ?, TeléfonoContacto = ?, CorreoInstitucional = ? WHERE ID = ?";
        PreparedStatement updatePs = con.prepareStatement(updateSql);
        updatePs.setInt(1, numero);
        updatePs.setString(2, tel);
        updatePs.setString(3, correo);
        updatePs.setInt(4, id);
        updatePs.executeUpdate();
        JOptionPane.showMessageDialog(null, "Datos de la institución actualizadas.");
        
    } else {
        // La institución con el ID proporcionado no existe en la base de datos
        JOptionPane.showMessageDialog(null, "No se encontró ninguna institución con el ID proporcionado.");
    }
    
    // Cierra las conexiones y los recursos
    resultSet.close();
    selectPs.close();
    con.close();
}
    public int RegistrarProv(String Nombre, String Dep, String Ciudad, int Numero, String tel, String producto) throws ClassNotFoundException, SQLException{
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    String connectionURL = "jdbc:sqlserver://DESKTOP-M3DKATA\\SQLEXPRESS:1433;databaseName=PAE;user=userSQL;password=1097096174;";
    Connection con = DriverManager.getConnection(connectionURL);
    
    // Prepara para insertar los datos en la base de datos y obtener el ID generado
    String sql1 = "insert into Proveedores(Proveedor, Departamento, Municipio, NoProductos, Teléfono, Producto) values(?,?,?,?,?,?)";
    PreparedStatement ps = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS); 
    
    // Se ingresan los datos en la base de datos
    ps.setString(1, Nombre);
    ps.setString(2, Dep);
    ps.setString(3, Ciudad);
    ps.setInt(4, Numero);
    ps.setString(5, tel);
    ps.setString(6, producto);
    
    // Ejecuta la inserción y obtén el ID generado
    int affectedRows = ps.executeUpdate();
    int generatedId = -1;  // Valor predeterminado en caso de que no se genere un ID
    
    if (affectedRows > 0) {
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            generatedId = generatedKeys.getInt(1);  // Obtiene el ID generado
        }
    }
    
    // Cierra la conexión y muestra el mensaje
    con.close();
    JOptionPane.showMessageDialog(null, "Datos agregados a la base de datos. ID generado: " + generatedId);
    
    return generatedId; 
    }


}