package mike.personalfitnesstracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField userNameTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private Button signupButton;
    @FXML
    private Button loginButton;
    @FXML
    private boolean darkmode;

    @javafx.fxml.FXML
    public void initialize() {
        if ( darkmode==true) {
            SettingsController.setDarkMode();
        }

    }

    @FXML
    protected void login (ActionEvent event) throws IOException {
        String userName = userNameTF.getText();
        String password = passwordTF.getText();

        Parent homeParent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene signUpScene = new Scene(homeParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(signUpScene);
        window.centerOnScreen();
        window.show();

        userNameTF.clear();
        passwordTF.clear();

    }


    @FXML
    public void signup(ActionEvent event) throws IOException {
       Parent signUpParent = FXMLLoader.load(getClass().getResource("signup.fxml"));
       Scene signUpScene = new Scene(signUpParent);

       Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

       window.setScene(signUpScene);
       window.centerOnScreen();
       window.show();
    }

}