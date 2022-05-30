/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ap1.BancoDado;

import ap1.Classes.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bruno 5600
 */
public class ClienteBD {
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Cliente> listaCliente = new ArrayList<>();
    
    public void cadastrarCliente(Cliente cliente){
        String sql = "insert into cliente (id_cliente, nome_cliente, cpf_cliente) values (?,?,?)";
        
        con = new Conexao().conectar();
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, String.valueOf(cliente.getId()));
            pstm.setString(2, cliente.getNome());
            pstm.setString(3, cliente.getCPF());
            
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Cliente> pesquisarCliente() {
        String sql = "select * from cliente";
       
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome_cliente"));
                cliente.setCPF(rs.getString("cpf_cliente"));
                
                listaCliente.add(cliente);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return listaCliente;
    }
}
