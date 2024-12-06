package mike.personalfitnesstracker;

import javafx.scene.control.Alert;

public class AlertManager {
    public static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert a = new Alert(alertType);
        a.setHeight(375);
        a.setWidth(250);

        a.setHeaderText(title);
        a.setContentText(message + "\n");
        a.show();
    }
}
