package mike.personalfitnesstracker;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    static Account currentAccount;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @FXML
    protected void login (ActionEvent event) throws IOException {

        //get username and password from text fields
        String userName = userNameTF.getText();
        String password = passwordTF.getText();

        String invalid = "";

        boolean found = false;

        //asynchronously retrieve all documents from collection 'Person' in Firebase
        ApiFuture<QuerySnapshot> future =  Main.fstore.collection("Person").get();

        //List collection used to iterate through all documents
        List<QueryDocumentSnapshot> documents;

        try{

            //get all documents from Firebase
            documents = future.get().getDocuments();
            if(documents.size()>0)
            {
                System.out.println("Getting (reading) data from firebase database....");

                //iterate through Firebase Db, searching for respective Username and Password combination. If found, go to
                //home-screen
                for (QueryDocumentSnapshot document : documents)
                {
                    String fbUsername = (String)document.getData().get("Username");
                    String fbPassword = (String)document.getData().get("Password");
                    if(fbUsername.equals(userName) && fbPassword.equals(password)){
                        found = true;

                        //get Number values from Firebase Db. Comes back as a 'Long'
                        Long longAge = (Long)document.getData().get("Age");
                        Long longFT = (Long)document.getData().get("Current Ft");
                        Long longInches = (Long)document.getData().get("Current Inches");

                        //use intValue method from 'Long' class to convert Long to int value
                        int age = longAge.intValue();
                        int ft = longFT.intValue();
                        int inches = longInches.intValue();
                        double currWeight = (Double)document.getData().get("Current Weight");

                        double targetWeight = (Double)document.getData().get("Target Weight");
                        String uid = document.getId();
                        System.out.println(uid);

                        //initialize 'currentAccount' with the current account that was logged into
                        currentAccount = new Account(fbUsername
                                ,fbPassword
                                ,(String)document.getData().get("Email")
                                ,(String)document.getData().get("First Name")
                                ,(String)document.getData().get("Last Name")
                                ,age
                                ,currWeight
                                ,ft
                                ,inches
                                ,targetWeight
                                ,(String)document.getData().get("Profile Picture BlobInfo")
                                );

                        System.out.println(currentAccount);
                        break;
                    }
                }
            }
            else
            {
                System.out.println("No data within Firebase database");
            }

            //if not found, alert user as such
            if(!found){
                AlertManager.showAlert(Alert.AlertType.ERROR, "Error", "Username or Password incorrect");
            }
            else{
                SceneManager.switchScene("checkin.fxml");

                userNameTF.clear();
                passwordTF.clear();
            }
        }
        catch (InterruptedException | ExecutionException ex)
        {
            System.out.println("No data");
        }
    }


    @FXML
    public void signup(ActionEvent event) throws IOException {
        SceneManager.switchScene("signup.fxml");
    }
}