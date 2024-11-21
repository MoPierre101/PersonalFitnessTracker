package mike.personalfitnesstracker;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class LoginController {

    @FXML
    private TextField userNameTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private Button signupButton;
    @FXML
    private Button loginButton;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @FXML
    protected void login (ActionEvent event) throws IOException {
        String userName = userNameTF.getText();
        String password = passwordTF.getText();

        //asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future =  Main.fstore.collection("Person").get();

        List<QueryDocumentSnapshot> documents;

        try{
            documents = future.get().getDocuments();
            if(documents.size()>0)
            {
                System.out.println("Getting (reading) data from firebase database....");

                for (QueryDocumentSnapshot document : documents)
                {
                    String fbUsername = (String)document.getData().get("Username");
                    String fbPassword = (String)document.getData().get("Password");
                    if(fbUsername.equals(userName) && fbPassword.equals(password)){

                    }
                }
            }
            else
            {
                System.out.println("No data");
            }
        }
        catch (InterruptedException | ExecutionException ex)
        {
            System.out.println("No data");
        }

        Parent homeParent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene signUpScene = new Scene(homeParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(signUpScene);
        window.centerOnScreen();
        window.show();

        userNameTF.clear();
        passwordTF.clear();
    }


    @FXML
    public void signup(ActionEvent event) throws IOException {
       Parent signUpParent = FXMLLoader.load(getClass().getResource("signup.fxml"));
       Scene signUpScene = new Scene(signUpParent);

       Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

       window.setScene(signUpScene);
       window.centerOnScreen();
       window.show();
    }

}