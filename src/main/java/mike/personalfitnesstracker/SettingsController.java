package mike.personalfitnesstracker;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

public class SettingsController {

    @FXML
    private RadioButton lightModeRadioButton;

    @FXML
    private RadioButton darkModeRadioButton;
    @FXML
    private ComboBox fontSizeComboBox;
    @FXML
    private ComboBox fontSizeComboBox1;

    private File pfpFile;

    @FXML
    private Button chooseImageBtn;

    public void initialize() {

    }


    @FXML
    private void handleThemeChange() {
        if (lightModeRadioButton.isSelected()) {
            setLightMode();
            //asynchronously retrieve all documents from collection 'Person' in Firebase where the Username is equal to
            //the currently logged-in user
            ApiFuture<QuerySnapshot> query = Main.fstore.collection("Person")
                    .whereEqualTo("Username", LoginController.currentAccount.getUsername()).get();

        } else if (darkModeRadioButton.isSelected()) {
            setDarkMode();

            //asynchronously retrieve all documents from collection 'Person' in Firebase where the Username is equal to
            //the currently logged-in user
            ApiFuture<QuerySnapshot> query = Main.fstore.collection("Person")
                    .whereEqualTo("Username", LoginController.currentAccount.getUsername()).get();

        }
    }


    private void setLightMode() {

//        rootPane.getScene().getStylesheets().clear();
//        rootPane.getScene().getStylesheets().add(getClass().getResource("resources/styles/style.css").toExternalForm());
    }


    private void setDarkMode() {
//        rootPane.getScene().getStylesheets().clear();
//        rootPane.getScene().getStylesheets().add(getClass().getResource("resources/styles/darkMode.css").toExternalForm());
    }

    @FXML
    private void handleReturnAction(ActionEvent actionEvent) throws IOException {
        SceneManager.switchScene("home.fxml");
    }


    private String uploadProfilePicture(File file){
        String destinationPath = "pfps/OK.jpg";

        if(file.exists()){


            try {
                // Initialize Firebase App
                FileInputStream serviceAccount = new FileInputStream("src/main/resources/mike/personalfitnesstracker/key.json");
                StorageOptions options = StorageOptions.newBuilder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();

                Storage storage = options.getService();

                String bucketName = "personal-fitness-tracker-66576.firebasestorage.app"; // Replace with your bucket name
                destinationPath = "pfps/" + UUID.randomUUID() +  file.getName(); // Path in the bucket'
                String filename = file.getName();
                String fileExtension = filename.substring(filename.lastIndexOf(".") + 1);
                // Read the file and upload to the bucket
                byte[] fileBytes = Files.readAllBytes(file.toPath());
                BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, destinationPath)
                        .setContentType("image/"+fileExtension) // Set the MIME type
                        .build();
                storage.create(blobInfo, fileBytes);

                System.out.println("File uploaded successfully to: " + destinationPath);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }




        return destinationPath;
    }


    @FXML
    public void chooseFileButtonClicked(ActionEvent actionEvent) {
        handleChooseFileButtonClicked();
    }

    private void handleChooseFileButtonClicked(){
        try {
            // Configure FileChooser
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select an Image to Upload");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
            );

            // Show FileChooser and get the selected file
            Stage currentStage = (Stage) chooseImageBtn.getScene().getWindow();
            File selectedFile = fileChooser.showOpenDialog(currentStage);
            if (selectedFile != null) {
                pfpFile = selectedFile;
                uploadProfilePicture(pfpFile);
            } else {
                System.out.println("No file selected.");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void handleChangeUsername(ActionEvent actionEvent) {
    }
}