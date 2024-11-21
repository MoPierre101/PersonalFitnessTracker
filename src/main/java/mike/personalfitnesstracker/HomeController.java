package mike.personalfitnesstracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Label welcomeLabel;
    @FXML
    private Label targetCalorieLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label BMILabel;
    @FXML
    private Label totalStepLabel;

    private boolean darkmode;

    @javafx.fxml.FXML
    public void initialize() {
     if ( darkmode==true) {
         SettingsController.setDarkMode();
     }
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        Parent loginParent = FXMLLoader.load(getClass().getResource("choicescreen.fxml"));
        Scene loginScene = new Scene(loginParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(loginScene);
        window.centerOnScreen();
        window.show();
    }

    @FXML
    public void showGraphs(ActionEvent event) throws IOException {
        Parent chartsParent = FXMLLoader.load(getClass().getResource("charts.fxml"));
        Scene chartsScene = new Scene(chartsParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(chartsScene);
        window.centerOnScreen();
        window.show();
    }
}
