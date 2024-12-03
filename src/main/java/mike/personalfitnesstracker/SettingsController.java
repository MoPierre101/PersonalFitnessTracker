package mike.personalfitnesstracker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;

public class SettingsController {
    @FXML
    private static Pane rootPane;

    @FXML
    private RadioButton lightModeRadioButton;

    @FXML
    private RadioButton darkModeRadioButton;

    @FXML
    private ComboBox<Integer> fontSizeComboBox;

    @FXML
    private Button applyFontSizeButton;

    public void initialize() {
        setLightMode();

        fontSizeComboBox.getItems().addAll(12, 14, 16, 18, 20, 22, 24);
        fontSizeComboBox.setValue(14); // Set a default font size
        applyFontSizeButton.setOnAction(event -> handleFontSizeChange());
    }

    @FXML
    private void handleThemeChange() {
        if (lightModeRadioButton.isSelected()) {
            setLightMode();
        } else if (darkModeRadioButton.isSelected()) {
            setDarkMode();
        }
    }

    private void setLightMode() {
        rootPane.getScene().getStylesheets().clear();
        rootPane.getScene().getStylesheets().add(getClass().getResource("/styles/lightMode.css").toExternalForm());
    }

    static void setDarkMode() {
        rootPane.getScene().getStylesheets().clear();
        rootPane.getScene().getStylesheets().add(SettingsController.class.getResource("/styles/darkMode.css").toExternalForm());
    }

    @FXML
    private void handleFontSizeChange() {
        Integer selectedSize = fontSizeComboBox.getValue();
        rootPane.setStyle("-fx-font-size: " + selectedSize + "px;");
    }

    @FXML
    private void handleUpdateProfilePicture() {

    }

    @FXML
    private void handleChangeUsername() {

    }

    @FXML
    private void handleReturnAction() {

    }
}