package mike.personalfitnesstracker;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private static Stage primaryStage;

    public static void setStage(Stage stage){
        primaryStage = stage;
    }


    public static void switchScene(String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(SceneManager.class.getResource(fxmlFile));
        primaryStage.getScene().setRoot(root);
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        if(LoginController.currentAccount.getDarkMode()){
            primaryStage.getScene().getStylesheets().clear();
            primaryStage.getScene().getStylesheets().add(SceneManager.class.getResource("resources/styles/style.css").toExternalForm());
        }
    }
}
