package mike.personalfitnesstracker;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField userNameTF;
    @FXML
    private TextField passwordTF;

    @FXML
    protected void onLoginButtonClick() {
        String userName = userNameTF.getText();
        String password = passwordTF.getText();
        //insert code here to login

        userNameTF.clear();
        passwordTF.clear();
    }


    @FXML
    public void onSignupButtonPress() {
        //insert code here to allow user to signup and create an account
    }
}