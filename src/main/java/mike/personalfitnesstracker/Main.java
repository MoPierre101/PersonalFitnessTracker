package mike.personalfitnesstracker;


import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.FirebaseAuth;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Firestore fstore;

    public static FirebaseAuth fauth;

    public final FirestoreContext contextFirebase = new FirestoreContext();

    @Override
    public void start(Stage stage) throws IOException {

        //initialize Firebase
        //fstore = contextFirebase.firebase();
        //fauth = FirebaseAuth.getInstance();


        SceneManager.setStage(stage);
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setScene(new Scene(root));
        stage.show();

//            Parent loginParent = FXMLLoader.load(getClass().getResource("login.fxml"));
//            Scene loginScene = new Scene(loginParent);
//
//            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//            window.setScene(loginScene);
//            window.centerOnScreen();
//            window.show();

    }

    public static void main(String[] args) {
        launch();

        //Testing JavaFX Graphs


        //System.exit(0);
        //hi
    }
}