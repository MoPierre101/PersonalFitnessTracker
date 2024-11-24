package mike.personalfitnesstracker;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class CheckInController {
    @javafx.fxml.FXML
    private TextField dailyWeightTF;
    @javafx.fxml.FXML
    private TextField currentDateTF;

    static String docRef;

    @javafx.fxml.FXML
    public void initialize() {

    }


    @javafx.fxml.FXML
    public void cancel(ActionEvent actionEvent) throws IOException {
        SceneManager.switchScene("login.fxml");
    }

    @javafx.fxml.FXML
    public void checkIn(ActionEvent actionEvent) throws IOException {
        String dailyWeight = dailyWeightTF.getText();
        String currentDate = currentDateTF.getText();

        //use regex to check if weight and date are correctly inputted
        String invalid = "";

        if(!PatternChecker.isCorrectWeight(dailyWeight)) {
            if(dailyWeight.isEmpty()){
                invalid += "Target weight cannot be empty!\n";
            }
            else{
                invalid += "Invalid target weight!\n";
            }
        }

        if(!PatternChecker.isValidDate(currentDate)) {
            if(currentDate.isEmpty()){
                invalid += "Current date cannot be empty!\n";
            }
            else{
                invalid += "Invalid current date!\n";
            }
        }

        //if either dailyWeight or currentDate are invalid, display error
        if(!invalid.isEmpty()){
            AlertManager.showAlert(Alert.AlertType.WARNING, "Invalid input", invalid);
        }
        //otherwise, add data to Firebase
        else{

            //asynchronously retrieve all documents from collection 'Person' in Firebase where the Username is equal to
            //the currently logged-in user
            ApiFuture<QuerySnapshot> query = Main.fstore.collection("Person")
                    .whereEqualTo("Username", LoginController.currentAccount.getUsername()).get();

            try{
                QuerySnapshot querySnapshot = query.get();
                for(DocumentSnapshot document : querySnapshot.getDocuments()){

                    //Reference the document
                    DocumentReference personDoc = document.getReference();

                    //get the ID of the document
                    docRef = document.getId();

                    //Add the subcollection
                    ApiFuture<DocumentReference> subcollection = personDoc.collection("WeightLog")
                            .add(Map.of(
                                    "Weight", Double.parseDouble(dailyWeight),
                                    "Date", currentDate
                            ));
                    System.out.println("Added to subcollection with ID: " + subcollection.get().getId());
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }

            AlertManager.showAlert(Alert.AlertType.INFORMATION, "Success!", "Check in completed");

            //go back to home screen after successful check-in
            SceneManager.switchScene("home.fxml");
        }
    }
}