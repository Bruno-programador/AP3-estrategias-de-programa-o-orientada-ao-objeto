package ap1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stagePrincipal;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("fxml/TelaPrincipal"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("AP 1");
        stage.show();
        stagePrincipal = stage;
    }
    
    public static void iniciarDono(Stage stage){
        stage.initOwner(stagePrincipal);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return (Parent)fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
}