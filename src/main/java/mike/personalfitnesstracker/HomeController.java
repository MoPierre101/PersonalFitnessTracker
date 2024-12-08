package mike.personalfitnesstracker;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.cloud.storage.*;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static mike.personalfitnesstracker.SceneManager.getPrimaryStage;


public class HomeController {

    @FXML
    private Label welcomeLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label BMILabel;
    @FXML
    private Label totalStepLabel;
    @FXML
    private Label targetWeightLabel;

    @FXML
    private ImageView avatorImageView;


    @FXML
    private Button chooseImageBtn;

    private File pfpFile;






    @javafx.fxml.FXML
    public void initialize() {
        welcomeLabel.setText("Welcome " + LoginController.currentAccount.getUsername() + "!");
        targetWeightLabel.setText("Target weight: " + LoginController.currentAccount.getTargetWeight() + " lbs");
        weightLabel.setText("Current weight: " + LoginController.currentAccount.getWeight() + " lbs");
        BMILabel.setText("BMI: " + LoginController.currentAccount.calcBMI());


        loadProfilePicture();


        // Add a listener to the name property
//        Main.isActive.addListener((observable, oldValue, newValue) -> {
//            if (newValue) {
//                System.out.println("True");
//                loadProfilePicture();
//            }else{
//                System.out.println("False");
//            }
//        });



    }



    @FXML
    public void logout(ActionEvent event) throws IOException {
        SceneManager.switchScene("login.fxml");
    }

    @FXML
    public void showGraphs(ActionEvent event) throws IOException {
        SceneManager.switchScene("charts.fxml");
    }

    @FXML
    public void settings(ActionEvent actionEvent) throws IOException{
        SceneManager.switchScene("settings.fxml");
    }

    @FXML
    public void workout(ActionEvent actionEvent) throws IOException {
        SceneManager.switchScene("choicescreen.fxml");
    }

    @FXML
    public void checkIn(ActionEvent actionEvent) throws IOException {
        SceneManager.switchScene("checkin.fxml");
    }

    @FXML
    private void loadProfilePicture() {
        // load the image
        // Load the image
        Image image;

        try {
            String url = getProfilePictureUrl(LoginController.currentAccount.getPfpBlobInfo());
            System.out.println(url);
            image = new Image(url);
        }catch (Exception e){
            image = new Image("https://cdn.pixabay.com/photo/2024/05/26/10/15/bird-8788491_1280.jpg");
        }
        avatorImageView.setImage(image);

        // Create a circular clip
        double size = 100; // Diameter of the circle
        Circle clip = new Circle(size / 2, size / 2, size / 2);

        // Set ImageView size larger than the clip to ensure full coverage
        avatorImageView.setFitWidth(size);
        avatorImageView.setFitHeight(size);
        avatorImageView.setPreserveRatio(false); // Disable aspect ratio preservation

        // Set the clip to the ImageView
        avatorImageView.setClip(clip);

        // Optional: Add a circular border
        Circle border = new Circle(size / 2, size / 2, size / 2);
        border.setStroke(Color.BLUE);
        border.setStrokeWidth(5);
        border.setFill(null); // Transparent inside
    }



    private String getProfilePictureUrl(String pfpBlobName){
        String profilePictureUrl = "";
        try {
            // Initialize Firebase App
            FileInputStream serviceAccount = new FileInputStream("src/main/resources/mike/personalfitnesstracker/key.json");
            StorageOptions options = StorageOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            Storage storage = options.getService();

            BlobId blobId = BlobId.of("personal-fitness-tracker-66576.firebasestorage.app", pfpBlobName);
            Blob blob = storage.get(blobId);
            profilePictureUrl = blob.signUrl(
                    2,
                    TimeUnit.MINUTES,
                    Storage.SignUrlOption.withV4Signature()
                    ).toURI().toString();;



        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(profilePictureUrl);
        return profilePictureUrl;
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
                updatePfpDB(uploadProfilePicture(pfpFile));
                loadProfilePicture();

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

    private void updatePfpDB(String blobInfo){
        //asynchronously retrieve all documents from collection 'Person' in Firebase where the Username is equal to
        //the currently logged-in user
        ApiFuture<QuerySnapshot> query = Main.fstore.collection("Person")
                .whereEqualTo("Username", LoginController.currentAccount.getUsername()).get();

        try{
            QuerySnapshot querySnapshot = query.get();
            for(DocumentSnapshot document : querySnapshot.getDocuments()){

                //Reference the document
                DocumentReference personDoc = document.getReference();

                //change the current account's weight to what the user checked-in with
                LoginController.currentAccount.setPfpBlobInfo(blobInfo);

                //update the 'Current Weight' field in Firebase
                ApiFuture<WriteResult> writeResult = personDoc.update("Profile Picture BlobInfo", blobInfo);
                System.out.println(blobInfo);
            }
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }



}
