package mike.personalfitnesstracker;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
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

    @javafx.fxml.FXML
    public void initialize() {

    }


    @javafx.fxml.FXML
    public void cancel(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(homeScene);
        window.centerOnScreen();
        window.show();
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
            Alert a = new Alert(Alert.AlertType.WARNING);

            a.setHeight(350);
            a.setWidth(250);

            a.setHeaderText("Invalid input");

            a.setContentText(invalid);

            a.show();
        }
        //otherwise, add data to Firebase
        else{

            //creating a collection called 'Person'
            //UUID randomization
            DocumentReference docRef = Main.fstore.collection("WeightLog").document(UUID.randomUUID().toString());

            //create a collection to store user data
            Map<String, Object> data = new HashMap<>();

            data.put("DailyWeight", dailyWeight);
            data.put("CurrentDate", currentDate);

            //write data to 'WeightLog' collection within Firebase
            ApiFuture<WriteResult> result = docRef.set(data);

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeight(300);
            a.setWidth(250);

            a.setHeaderText("Success!");
            a.setContentText("Check in completed!");
            a.show();

            //go back to home screen after successful check-in
            Parent loginParent = FXMLLoader.load(getClass().getResource("home.fxml"));
            Scene loginScene = new Scene(loginParent);

            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            window.setScene(loginScene);
            window.centerOnScreen();
            window.show();
        }
    }
}