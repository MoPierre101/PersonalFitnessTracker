package mike.personalfitnesstracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsController {

    @FXML
    private RadioButton lightModeRadioButton;

    @FXML
    private RadioButton darkModeRadioButton;
    @FXML
    private ComboBox fontSizeComboBox;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private ComboBox fontSizeComboBox1;

    public void initialize() {

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
        rootPane.getScene().getStylesheets().add(getClass().getResource("resources/styles/lightMode.css").toExternalForm());
    }


    private void setDarkMode() {
        rootPane.getScene().getStylesheets().clear();
        rootPane.getScene().getStylesheets().add(getClass().getResource("resources/styles/darkMode.css").toExternalForm());
    }


    @FXML
    private void handleUpdateProfilePicture() {

    }

    @FXML
    private void handleChangeUsername() {

    }

    @FXML
    private void handleReturnAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(homeScene);
        window.centerOnScreen();
        window.show();
    }
}