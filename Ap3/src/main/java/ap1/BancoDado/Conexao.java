/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ap1.BancoDado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bruno 5600
 */
public class Conexao {
    public Connection conectar(){
        Connection con = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/ap3?user=root&password=";
            con = DriverManager.getConnection(url);
        } 
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}
