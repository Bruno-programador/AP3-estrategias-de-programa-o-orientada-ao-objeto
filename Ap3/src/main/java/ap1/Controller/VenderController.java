/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ap1.Controller;

import ap1.Classes.Cliente;
import ap1.Classes.Motocicleta;
import ap1.Classes.Vendas;
import static ap1.Controller.CRUDclienteController.listaCliente;
import static ap1.Controller.CRUDmotocicletaController.listaMotocicleta;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bruno 5600
 */
public class VenderController implements Initializable {

    @FXML
    public VBox telaVender;
    
    @FXML
    public ChoiceBox<Cliente> vendaCliente;
    @FXML
    public ChoiceBox<Motocicleta> vendaMotocicleta;
    @FXML
    public ChoiceBox<String> vendaParcelas;
    @FXML
    public Label vendaPreco;
    @FXML
    public Label vendaPrecoParcela;
    
    private Vendas venda = new Vendas();

    public static List<Vendas> listaVendas = new ArrayList();
    
    private String[] valorParcelas = {"1x", "6x", "12x", "18x", "24x", "30x"};
    
    double valorParcelado;
    
    private String nomeParaId(int num){
        return venda.getCliente().getNome() + "_" + venda.getMotocicleta().getModelo() + "_" + Integer.toString(num);
    }
    
    public void sair() {
        ((Stage) telaVender.getScene().getWindow()).close();
    }
    
    @FXML
    public void efetuarVenda(){
        venda.setCliente(vendaCliente.getValue());
        venda.setMotocicleta(vendaMotocicleta.getValue());
        venda.setParcelas(vendaParcelas.getValue());
        
        if (vendaCliente.getValue() != null || vendaMotocicleta.getValue() != null || vendaParcelas.getValue() != null){
            
            int num = 1;
            
            for (Vendas i : listaVendas){
                if (nomeParaId(num).equals(i.getId())){
                    num++;
                }
            }
            venda.setId(nomeParaId(num));
            venda.setValorParcelas(valorParcelado);
            listaVendas.add(venda);
                
            sair();
        }

        ap1.Controller.HistoricoController.AtualizarValoresHistorico();
    }
    
    public void vendaMostrarPreco(ActionEvent event){
        vendaPreco.setText(String.format("%,.02f", vendaMotocicleta.getValue().getPreco()));
        vendaMostrarPrecoParcelas(event);
    }
    
    public void vendaMostrarPrecoParcelas(ActionEvent event){
        if (vendaMotocicleta.getValue() != null && vendaParcelas.getValue() != null) {
            double valorBruto = vendaMotocicleta.getValue().getPreco();
            valorParcelado = valorBruto;
            int valorParcela = 1;
            if ("6x".equals(vendaParcelas.getValue())){
                valorParcela = 6;
            }
            else if ("12x".equals(vendaParcelas.getValue())){
                valorParcela = 12;
            }
            else if ("18x".equals(vendaParcelas.getValue())){
                valorParcela = 18;
            }
            else if ("24x".equals(vendaParcelas.getValue())){
                valorParcela = 24;
            }
            else if ("30x".equals(vendaParcelas.getValue())){
                valorParcela = 30;
            }
            valorParcelado = valorBruto/valorParcela;
            vendaPrecoParcela.setText(String.format("%,.02f", valorParcelado));
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vendaCliente.getItems().addAll(listaCliente);
        vendaMotocicleta.getItems().addAll(listaMotocicleta);
        vendaParcelas.getItems().addAll(valorParcelas);
        vendaParcelas.setValue("1x");
        
        vendaMotocicleta.setOnAction(this::vendaMostrarPreco);
        vendaParcelas.setOnAction(this::vendaMostrarPrecoParcelas);
    }    
    
}
