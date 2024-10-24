package mike.personalfitnesstracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController
{
    @FXML
    private RadioButton newcomerRB;
    @FXML
    private RadioButton proRB;
    @FXML
    private CheckBox RippedCB;
    @FXML
    private RadioButton amateurRB;
    @FXML
    private CheckBox loseWeightCB;
    @FXML
    private CheckBox gainMuscleCB;
    @FXML
    private TextField enterPasswordTF;
    @FXML
    private TextField enterEmailTF;
    @FXML
    private TextField enterUserTF;
    @FXML
    private TextField enterAgeTF;
    @FXML
    private TextField enterCurWeightTF;
    @FXML
    private TextField enterNameTF;
    @FXML
    private TextField enterTargetWeightTF;
    @FXML
    private TextField enterHeightTF;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @FXML
    public void getLevel(ActionEvent actionEvent) {

    }

    @FXML
    public void getGoals(ActionEvent actionEvent) {

    }

    @FXML
    public void createAccount (ActionEvent event) throws IOException {
        Parent loginParent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene loginScene = new Scene(loginParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(loginScene);
        window.centerOnScreen();
        window.show();
    }
}