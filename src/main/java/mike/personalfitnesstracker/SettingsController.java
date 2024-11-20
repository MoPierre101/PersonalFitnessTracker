package mike.personalfitnesstracker;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;

public class SettingsController {

    @FXML
    private Pane rootPane;

    @FXML
    private RadioButton lightModeRadioButton;

    @FXML
    private RadioButton darkModeRadioButton;


    public void initialize() {
        setLightMode();
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


    private void setDarkMode() {
        rootPane.getScene().getStylesheets().clear();
        rootPane.getScene().getStylesheets().add(getClass().getResource("/styles/darkMode.css").toExternalForm());
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