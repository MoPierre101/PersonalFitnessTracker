package mike.personalfitnesstracker;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;

public class Main extends Application {

    public static Firestore fstore;

    public static FirebaseAuth fauth;

    public final FirestoreContext contextFirebase = new FirestoreContext();

    @Override
    public void start(Stage stage) throws IOException {

        //initialize Firebase
        fstore = contextFirebase.firebase();
        fauth = FirebaseAuth.getInstance();



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