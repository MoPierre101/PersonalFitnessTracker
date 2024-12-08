package mike.personalfitnesstracker;


import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;

public class Main extends Application {

    public static BooleanProperty isActive = new SimpleBooleanProperty(false);

    public static Firestore fstore;

    public static FirebaseAuth fauth;

    public final FirestoreContext contextFirebase = new FirestoreContext();

    @Override
    public void start(Stage stage) throws IOException {

        //initialize Firebase
        fstore = contextFirebase.firebase();
        fauth = FirebaseAuth.getInstance();


        SceneManager.setStage(stage);
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}