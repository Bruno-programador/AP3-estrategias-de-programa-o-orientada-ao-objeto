/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ap1.Controller;

import ap1.Classes.Motocicleta;
import static ap1.Controller.CRUDmotocicletaController.listaMotocicleta;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Bruno 5600
 */
public class RegMotocicletaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public ListView<Motocicleta> regMotocicletaList;
    @FXML
    public TextField regMotocicletaId;
    @FXML
    public TextField regMotocicletaModelo;
    @FXML
    public TextField regMotocicletaPreco;
    
    private static ObservableList<Motocicleta> observableList;
    
    private static ListView<Motocicleta> lista;
           

    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        lista = regMotocicletaList;
        AtualizarValoresMotocicleta();
    }
    
    @FXML
    public void atualizarInfoMotocicleta(){
        regMotocicletaId.setText(Integer.toString(lista.getSelectionModel().getSelectedItem().getId()));
        regMotocicletaModelo.setText(lista.getSelectionModel().getSelectedItem().getModelo());
        regMotocicletaPreco.setText(String.format("%,.02f", lista.getSelectionModel().getSelectedItem().getPreco()));
    }
    
    public static void AtualizarValoresMotocicleta(){
        observableList = FXCollections.observableArrayList(ap1.Controller.CRUDmotocicletaController.listaMotocicleta);
        lista.setItems(observableList);
    }
    
    @FXML
    public void deletarMoto(){
           listaMotocicleta.remove(lista.getSelectionModel().getSelectedIndex());
        
           AtualizarValoresMotocicleta();
        }
    
    @FXML
    public void atualizarMoto(){
           Motocicleta tempMoto = listaMotocicleta.get(lista.getSelectionModel().getSelectedIndex());
           tempMoto.setId(Integer.parseInt(regMotocicletaId.getText()));
           tempMoto.setModelo(regMotocicletaModelo.getText());
           tempMoto.setPreco(Integer.parseInt(regMotocicletaPreco.getText()));
        
           AtualizarValoresMotocicleta();
        }
}
