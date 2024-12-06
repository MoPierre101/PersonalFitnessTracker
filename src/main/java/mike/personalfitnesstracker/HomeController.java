package mike.personalfitnesstracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Label welcomeLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label BMILabel;
    @FXML
    private Label totalStepLabel;
    @FXML
    private Label targetWeightLabel;

    @javafx.fxml.FXML
    public void initialize() {
        welcomeLabel.setText("Welcome " + LoginController.currentAccount.getUsername() + "!");
        targetWeightLabel.setText("Target weight: " + LoginController.currentAccount.getTargetWeight() + " lbs");
        weightLabel.setText("Current weight: " + LoginController.currentAccount.getWeight() + " lbs");
        BMILabel.setText("BMI: " + LoginController.currentAccount.calcBMI());
        //come back to after!
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        SceneManager.switchScene("login.fxml");
    }

    @FXML
    public void showGraphs(ActionEvent event) throws IOException {
        SceneManager.switchScene("charts.fxml");
    }

    @FXML
    public void settings(ActionEvent actionEvent) throws IOException{
        SceneManager.switchScene("settings.fxml");
    }

    @FXML
    public void workout(ActionEvent actionEvent) throws IOException {
        SceneManager.switchScene("choicescreen.fxml");
    }

    @FXML
    public void checkIn(ActionEvent actionEvent) throws IOException {
        SceneManager.switchScene("checkin.fxml");
    }
}
