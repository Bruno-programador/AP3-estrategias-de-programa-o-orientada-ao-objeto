package ap1.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import ap1.Classes.Cliente;

/**
 *
 * @author Bruno 5600
 */
public class CRUDclienteController implements Initializable {

    @FXML
    public VBox telaCliente;
    
    @FXML
    public TextField clienteID;
    @FXML
    public TextField clienteNome;
    @FXML
    public TextField clienteCPF;
    
    private Cliente cliente = new Cliente();

    public static List<Cliente> listaCliente = new ArrayList();
    
    
    public void sair() {
        ((Stage) telaCliente.getScene().getWindow()).close();
    }
    
    @FXML
    public void pegarValores(){
        try{
            cliente.setId(Integer.parseInt(clienteID.getText()));
            cliente.setNome(clienteNome.getText());
            cliente.setCPF(clienteCPF.getText());

            listaCliente.add(cliente);
                
            sair();
        }
        catch(NumberFormatException e){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Dados Incorreto");

            alert.showAndWait();
        }
        
        ap1.Controller.RegClienteController.AtualizarValoresCliente();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
