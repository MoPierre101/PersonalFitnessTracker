import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CheckInController {

    @FXML
    private Label userName;

    @FXML
    private ImageView profileImage;

    @FXML
    private TextField stepsInput;

    @FXML
    private TextField bmiDisplay;

    // This method is triggered when the Submit button is clicked
    @FXML
    protected void handleSubmit() {
        // For now, just print the user's input to the console
        String steps = stepsInput.getText();
        System.out.println("Steps entered: " + steps);

        // Calculate BMI (in a real app, you would update the bmiDisplay based on actual data)
        // For demonstration, let's assume BMI is calculated elsewhere and just set it.
        bmiDisplay.setText("24.5");  // Just a placeholder value
    }

    // You can add a method here to initialize user data like setting profile image, user name, etc.
    public void initialize() {
        userName.setText("John Doe");
        // profileImage.setImage(...); // Load user's profile picture here
    }

}
