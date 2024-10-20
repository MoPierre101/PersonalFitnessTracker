package mike.personalfitnesstracker;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Settings {

    public ToggleGroup themeToggleGroup;
    public Button returnButton;
    @FXML
    private ComboBox<String> fontSizeComboBox;

    @FXML
    private RadioButton lightModeRadioButton;

    @FXML
    private RadioButton darkModeRadioButton;

    @FXML
    public void initialize() {
        // Populate the font sizes
        fontSizeComboBox.setItems(FXCollections.observableArrayList("Small", "Medium", "Large"));
    }

    @FXML
    private void handleReturnAction() {
        // Logic to return to the previous screen
        System.out.println("Returning to the previous screen...");
        // Implement navigation logic here
    }

    @FXML
    private void handleUpdateProfilePicture() {
        // Logic to update the profile picture
        System.out.println("Updating profile picture...");
        // Implement profile picture update logic here
    }

    @FXML
    private void handleChangeUsername() {
        // Logic to change the username
        System.out.println("Changing username...");
        // Implement username change logic here
    }

    @FXML
    private void handleLightMode() {
        // Logic to switch to light mode
        System.out.println("Switched to Light Mode");
        // Implement theme change logic here
    }

    @FXML
    private void handleDarkMode() {
        // Logic to switch to dark mode
        System.out.println("Switched to Dark Mode");
        // Implement theme change logic here
    }

}