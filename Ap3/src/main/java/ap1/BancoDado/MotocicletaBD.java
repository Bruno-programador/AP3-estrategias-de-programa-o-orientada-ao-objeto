/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ap1.BancoDado;

import ap1.Classes.Motocicleta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bruno 5600
 */
public class MotocicletaBD {
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Motocicleta> listaMotocicleta = new ArrayList<>();
    
    public void cadastrarMotocicleta(Motocicleta motocicleta){
        String sql = "insert into motocicleta (id_motocicleta, modelo_motocicleta, preco_motocicleta) values (?,?,?)";
        
        con = new Conexao().conectar();
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, String.valueOf(motocicleta.getId()));
            pstm.setString(2, motocicleta.getModelo());
            pstm.setString(3, String.valueOf(motocicleta.getPreco()));
            
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Motocicleta> pesquisarMotocicleta() {
        String sql = "select * from motocicleta";
       
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                Motocicleta motocicleta = new Motocicleta();
                motocicleta.setId(rs.getInt("id_motocicleta"));
                motocicleta.setModelo(rs.getString("modelo_motocicleta"));
                motocicleta.setPreco(rs.getDouble("preco_motocicleta"));
                
                listaMotocicleta.add(motocicleta);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return listaMotocicleta;
    }
}
