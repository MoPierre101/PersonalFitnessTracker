package mike.personalfitnesstracker;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Settings {

    @FXML
    private ToggleGroup themeToggleGroup;
    @FXML
    private Button themeButton;
    @FXML
    private ComboBox<String> fontSizeComboBox;
    @FXML
    private RadioButton lightModeRadioButton;
    @FXML
    private RadioButton darkModeRadioButton;

    @FXML
    public void initialize() {
        fontSizeComboBox.setItems(FXCollections.observableArrayList("Small", "Medium", "Large"));


        lightModeRadioButton.setOnAction(event -> handleLightMode());
        darkModeRadioButton.setOnAction(event -> handleDarkMode());


        fontSizeComboBox.setOnAction(event -> handleFontSizeChange());
    }

    @FXML
    private void handleReturnAction() {
        System.out.println("Returning to the previous screen...");
    }

    @FXML
    private void handleUpdateProfilePicture() {
        System.out.println("Updating profile picture...");

    }

    @FXML
    private void handleChangeUsername() {
        System.out.println("Changing username...");

    }

    @FXML
    private void handleLightMode() {
        System.out.println("Switched to Light Mode");

    }

    @FXML
    private void handleDarkMode() {
        System.out.println("Switched to Dark Mode");

    }

    @FXML
    private void handleFontSizeChange() {
        String selectedSize = fontSizeComboBox.getSelectionModel().getSelectedItem();
        System.out.println("Font size changed to: " + selectedSize);

    }
}