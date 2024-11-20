package mike.personalfitnesstracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class CheckInController {
    @javafx.fxml.FXML
    private TextField dailyWeightTF;
    @javafx.fxml.FXML
    private TextField currentDateTF;

    @javafx.fxml.FXML
    public void initialize() {

    }


    @javafx.fxml.FXML
    public void cancel(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(homeScene);
        window.centerOnScreen();
        window.show();
    }

    @javafx.fxml.FXML
    public void checkIn(ActionEvent actionEvent) {
        String dailyWeight = dailyWeightTF.getText();
        String currentDate = currentDateTF.getText();
    }
}