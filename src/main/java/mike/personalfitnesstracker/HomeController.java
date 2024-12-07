package mike.personalfitnesstracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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

    @FXML
    private ImageView avatorImageView;

    @javafx.fxml.FXML
    public void initialize() {
        welcomeLabel.setText("Welcome " + LoginController.currentAccount.getUsername() + "!");
        targetWeightLabel.setText("Target weight: " + LoginController.currentAccount.getTargetWeight() + " lbs");
        weightLabel.setText("Current weight: " + LoginController.currentAccount.getWeight() + " lbs");
        BMILabel.setText("BMI: " + LoginController.currentAccount.calcBMI());

        loadProfilePicture();
    }

    @FXML
    private void loadProfilePicture() {
        // Load the image
        Image image;
        try {
            image = new Image("get users profile picture");
        }catch (Exception e){
            image = new Image("https://cdn.pixabay.com/photo/2024/05/26/10/15/bird-8788491_1280.jpg");
        }
        avatorImageView.setImage(image);

        // Create a circular clip
        double size = 100; // Diameter of the circle
        Circle clip = new Circle(size / 2, size / 2, size / 2);

        // Set ImageView size larger than the clip to ensure full coverage
        avatorImageView.setFitWidth(size);
        avatorImageView.setFitHeight(size);
        avatorImageView.setPreserveRatio(false); // Disable aspect ratio preservation

        // Set the clip to the ImageView
        avatorImageView.setClip(clip);

        // Optional: Add a circular border
        Circle border = new Circle(size / 2, size / 2, size / 2);
        border.setStroke(Color.BLUE);
        border.setStrokeWidth(5);
        border.setFill(null); // Transparent inside
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
}
