/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ap1.Controller;

import ap1.Classes.Cliente;
import static ap1.Controller.CRUDclienteController.listaCliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;


/**
 * FXML Controller class
 *
 * @author Bruno 5600
 */
public class RegClienteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public ListView<Cliente> regClienteList;
    @FXML
    public TextField regClienteId;
    @FXML
    public TextField regClienteNome;
    @FXML
    public TextField regClienteCPF;
    
    private static ObservableList<Cliente> observableList;
    
    private static ListView<Cliente> lista;
           

    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        lista = regClienteList;
        AtualizarValoresCliente();
    }
    
    @FXML
    public void atualizarInfoCliente(){
        regClienteId.setText(Integer.toString(lista.getSelectionModel().getSelectedItem().getId()));
        regClienteNome.setText(lista.getSelectionModel().getSelectedItem().getNome());
        regClienteCPF.setText(lista.getSelectionModel().getSelectedItem().getCPF());
    }
    
    public static void AtualizarValoresCliente(){
        observableList = FXCollections.observableArrayList(ap1.Controller.CRUDclienteController.listaCliente);
        lista.setItems(observableList);
    }
    
    @FXML
    public void deletarCliente(){
           listaCliente.remove(lista.getSelectionModel().getSelectedIndex());
        
           AtualizarValoresCliente();
        }
    
    @FXML
    public void atualizarCliente(){
           Cliente tempCliente = listaCliente.get(lista.getSelectionModel().getSelectedIndex());
           tempCliente.setId(Integer.parseInt(regClienteId.getText()));
           tempCliente.setNome(regClienteNome.getText());
           tempCliente.setCPF(regClienteCPF.getText());
        
           AtualizarValoresCliente();
        }
    }
