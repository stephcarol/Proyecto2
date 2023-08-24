package ec.edu.espol.proyecto2;

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

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("ArbolTrie"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    //Cambia el grafo de scene a la scene
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    //cambia de scene
    public static void setRoot(FXMLLoader fxml) throws IOException {
        scene.setRoot(fxml.load());
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    //para obtener el controlador de otra scene
    public static FXMLLoader loadFXMLoader(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }
    
    public static void main(String[] args) {
        launch();
    }

}