/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ap1.BancoDado;

import ap1.Classes.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bruno 5600
 */
public class VendasBD {
    Connection con;
    PreparedStatement pstm;
    
    public void cadastrarVendas(Vendas vendas){
        String sql = "insert into vendas (id_vendas, cliente_vendas, motocicleta_vendas, parcelas, valor_parcelas) values (?,?,?,?,?)";
        
        con = new Conexao().conectar();
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, String.valueOf(vendas.getId()));
            pstm.setString(2, String.valueOf(vendas.getCliente()));
            pstm.setString(3, String.valueOf(vendas.getMotocicleta()));
            pstm.setString(4, vendas.getParcelas());
            pstm.setString(5, String.valueOf(vendas.getValorParcelas()));
            
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
