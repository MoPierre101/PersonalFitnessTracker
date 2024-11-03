package mike.personalfitnesstracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Personal Fitness Tracker Login");
        stage.setScene(scene);
        stage.show();




//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
//        stage.setTitle("Personal Fitness Tracker");
//        stage.setScene(scene);
//        stage.show();

    }

    public static void main(String[] args) {
        launch();

        //Testing JavaFX Graphs


        //System.exit(0);
    }
}