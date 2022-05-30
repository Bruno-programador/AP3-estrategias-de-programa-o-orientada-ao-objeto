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

import ap1.Classes.Motocicleta;

/**
 *
 * @author Bruno 5600
 */
public class CRUDmotocicletaController implements Initializable {

    @FXML
    public VBox telaMotocicleta;
    
    @FXML
    public TextField motocicletaID;
    @FXML
    public TextField motocicletaModelo;
    @FXML
    public TextField motocicletaPreco;
    
    private Motocicleta motocicleta = new Motocicleta();

    public static List<Motocicleta> listaMotocicleta = new ArrayList();
    
    
    public void sair() {
        ((Stage) telaMotocicleta.getScene().getWindow()).close();
    }
    
    @FXML
    public void pegarValores(){
        try{
        motocicleta.setId(Integer.parseInt(motocicletaID.getText()));
        motocicleta.setModelo(motocicletaModelo.getText());
        motocicleta.setPreco(Double.valueOf(motocicletaPreco.getText()));

        listaMotocicleta.add(motocicleta);
                
        sair();
        }
        catch(NumberFormatException e){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Dados Incorreto");

            alert.showAndWait();
        }
        ap1.Controller.RegMotocicletaController.AtualizarValoresMotocicleta();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
