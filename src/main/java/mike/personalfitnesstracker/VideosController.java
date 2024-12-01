package mike.personalfitnesstracker;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class VideosController {
    private MediaPlayer mediaPlayer;
    Button playPauseButton;
    Storage storage = StorageOptions.getDefaultInstance().getService();
    Bucket bucket = storage.get("");

    @FXML
    private TextField searchBox;


    @FXML
    public void initialize() {
        ArrayList <String> prefix = new ArrayList<>(List.of("bu/","bc/","bl/","iu/","ic/","il/","au/","ac/","al/"));
        int index;
        for(index = 0; index < prefix.size(); index++) {
            for (Blob blob : bucket.list(Storage.BlobListOption.prefix(prefix.get(index))).iterateAll()) {
                if (blob.getName().endsWith(".mp4")) {
                    Map<String, String> newMeta = new HashMap<>();
                    newMeta.put("tags", prefix.get(index).substring(0,prefix.get(index).length()-1));
                    blob.update(Storage.BlobTargetOption.);
                }
            }
        }
        searchBox.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                performSearch(searchBox.getText());
            }
        });
    }


    //Beginner Options
    @FXML
    private void bu_VidsClicked(ActionEvent event) throws IOException {
        List<String> VideoUrls = new ArrayList<>();
        List<String> VideoNames = new ArrayList<>();
        for (Blob blob : bucket.list().iterateAll()) {
            if (blob.getName().endsWith(".mp4")) {
                VideoNames.add(blob.getName());
                Map<String, String> metadata = blob.getMetadata();
                if (metadata != null && "bu".equals(metadata.get("type"))) {
                    String url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                            "/o/" + blob.getName() + "?alt=media";
                    VideoUrls.add(url);
                }
            }
        }
        setupPage(VideoNames,VideoUrls);



    }

    @FXML
    private void bc_VidsClicked(ActionEvent event) throws IOException {
        List<String> VideoUrls = new ArrayList<>();
        List<String> VideoNames = new ArrayList<>();
        String prefix = "Beginner/";
        for (Blob blob : bucket.list(Storage.BlobListOption.prefix(prefix)).iterateAll()) {
            if (blob.getName().endsWith(".mp4")) {
                VideoNames.add(blob.getName());
                Map<String, String> metadata = blob.getMetadata();
                if (metadata != null && "bc".equals(metadata.get("type"))) {
                    String url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                            "/o/" + blob.getName() + "?alt=media";
                    VideoUrls.add(url);
                }
            }
        }
        setupPage(VideoNames,VideoUrls);


    }

    @FXML
    private void bl_VidsClicked(ActionEvent event) throws IOException {
        List<String> VideoUrls = new ArrayList<>();
        List<String> VideoNames = new ArrayList<>();
        String prefix = "Beginner/";
        for (Blob blob : bucket.list(Storage.BlobListOption.prefix(prefix)).iterateAll()) {
            if (blob.getName().endsWith(".mp4")) {
                VideoNames.add(blob.getName());
                Map<String, String> metadata = blob.getMetadata();
                if (metadata != null && "bl".equals(metadata.get("type"))) {
                    String url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                            "/o/" + blob.getName() + "?alt=media";
                    VideoUrls.add(url);
                }
            }
        }
        setupPage(VideoNames,VideoUrls);


    }

    //Intermediate Options
    @FXML
    private void iu_VidsClicked(ActionEvent event) throws IOException {
        List<String> VideoUrls = new ArrayList<>();
        List<String> VideoNames = new ArrayList<>();
        String prefix = "Intermediate/";
        for (Blob blob : bucket.list(Storage.BlobListOption.prefix(prefix)).iterateAll()) {
            if (blob.getName().endsWith(".mp4")) {
                VideoNames.add(blob.getName());
                Map<String, String> metadata = blob.getMetadata();
                if (metadata != null && "iu".equals(metadata.get("type"))) {
                    String url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                            "/o/" + blob.getName() + "?alt=media";
                    VideoUrls.add(url);
                }
            }
        }
        setupPage(VideoNames,VideoUrls);
    }

    @FXML
    private void ic_VidsClicked(ActionEvent event) throws IOException {
        List<String> VideoUrls = new ArrayList<>();
        List<String> VideoNames = new ArrayList<>();
        String prefix = "Intermediate/";
        for (Blob blob : bucket.list(Storage.BlobListOption.prefix(prefix)).iterateAll()) {
            if (blob.getName().endsWith(".mp4")) {
                VideoNames.add(blob.getName());
                Map<String, String> metadata = blob.getMetadata();
                if (metadata != null && "ic".equals(metadata.get("type"))) {
                    String url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                            "/o/" + blob.getName() + "?alt=media";
                    VideoUrls.add(url);
                }
            }
        }
        setupPage(VideoNames,VideoUrls);


    }

    @FXML
    private void il_VidsClicked(ActionEvent event) throws IOException {
        List<String> VideoUrls = new ArrayList<>();
        List<String> VideoNames = new ArrayList<>();
        String prefix = "Intermediate/";
        for (Blob blob : bucket.list(Storage.BlobListOption.prefix(prefix)).iterateAll()) {
            if (blob.getName().endsWith(".mp4")) {
                VideoNames.add(blob.getName());
                Map<String, String> metadata = blob.getMetadata();
                if (metadata != null && "il".equals(metadata.get("type"))) {
                    String url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                            "/o/" + blob.getName() + "?alt=media";
                    VideoUrls.add(url);
                }
            }
        }
        setupPage(VideoNames,VideoUrls);



    }

    //Advanced Options
    @FXML
    private void au_VidsClicked(ActionEvent event) throws IOException {
        List<String> VideoUrls = new ArrayList<>();
        List<String> VideoNames = new ArrayList<>();
        String prefix = "Advanced/";
        for (Blob blob : bucket.list(Storage.BlobListOption.prefix(prefix)).iterateAll()) {
            if (blob.getName().endsWith(".mp4")) {
                VideoNames.add(blob.getName());
                Map<String, String> metadata = blob.getMetadata();
                if (metadata != null && "au".equals(metadata.get("type"))) {
                    String url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                            "/o/" + blob.getName() + "?alt=media";
                    VideoUrls.add(url);
                }
            }
        }
        setupPage(VideoNames,VideoUrls);



    }

    @FXML
    private void ac_VidsClicked(ActionEvent event) throws IOException {
        List<String> VideoUrls = new ArrayList<>();
        List<String> VideoNames = new ArrayList<>();
        String prefix = "Advanced/";
        for (Blob blob : bucket.list(Storage.BlobListOption.prefix(prefix)).iterateAll()) {
            if (blob.getName().endsWith(".mp4")) {
                VideoNames.add(blob.getName());
                Map<String, String> metadata = blob.getMetadata();
                if (metadata != null && "ac".equals(metadata.get("type"))) {
                    String url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                            "/o/" + blob.getName() + "?alt=media";
                    VideoUrls.add(url);
                }
            }
        }
        setupPage(VideoNames,VideoUrls);



    }

    @FXML
    private void al_VidsClicked(ActionEvent event) throws IOException {
        List<String> VideoUrls = new ArrayList<>();
        List<String> VideoNames = new ArrayList<>();
        String prefix = "Advanced/";
        for (Blob blob : bucket.list(Storage.BlobListOption.prefix(prefix)).iterateAll()) {
            if (blob.getName().endsWith(".mp4")) {
                VideoNames.add(blob.getName());
                Map<String, String> metadata = blob.getMetadata();
                if (metadata != null && "al".equals(metadata.get("type"))) {
                    String url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                            "/o/" + blob.getName() + "?alt=media";
                    VideoUrls.add(url);
                }
            }
        }
        setupPage(VideoNames,VideoUrls);



    }

    //Back Button Pressed
    private void returnClicked(){
        /*
    try {
        Parent vidsParent = FXMLLoader.load(getClass().getResource("choicescreen.fxml"));
        Scene vidScene = new Scene(vidsParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(vidScene);
        window.centerOnScreen();
        window.show();

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        */
    }

    private void playVideo(String videoPath) {
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }

        playPauseButton = new Button("Pause");
        playPauseButton.setOnAction(e -> togglePlayPause());

        File videoFile = new File(videoPath);
        Media media = new Media(videoFile.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(640);
        mediaView.setFitHeight(480);

        ProgressBar progressBar = new ProgressBar(0);
        mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            double progress = newValue.toSeconds() / mediaPlayer.getTotalDuration().toSeconds();
            progressBar.setProgress(progress);
        });
 
        Stage vboxStage = new Stage();
        vboxStage.setTitle("Example Video");
        VBox vbox = new VBox();
        vbox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vbox.setSpacing(25);
        vbox.getChildren().addAll(mediaView, playPauseButton, progressBar);
        Scene vboxScene = new Scene(vbox, 640, 480);
        vboxStage.setScene(vboxScene);
        vboxStage.show();

        mediaPlayer.play();

        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
        });

    }

    private void togglePlayPause() {
        if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.pause();
            playPauseButton.setText("Play");
        }else {
            mediaPlayer.play();
            playPauseButton.setText("Pause");
        }

    }

    private void setupPage(List <String> names, List <String> urls){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        int col = 0;
        int row = 0;
        int maxColumns = 2;
        Button backButton = new Button("Return");
        backButton.setOnAction(e->returnClicked());
        gridPane.add(backButton, col, row);
        for(int i = 0; i < names.size(); i++){
            Button button = new Button(names.get(i));
            int finalI = i;
            button.setOnAction(e -> playVideo(urls.get(finalI)));
            gridPane.add(button, col, row);

            col++;
            if(col == maxColumns){
                col = 0;
                row++;
            }
        }
    }

    private void performSearch(String searchTerm){
        searchTerm = searchBox.getText().toLowerCase();
        List<String> videoUrls = new ArrayList<>();
        List<String> videoNames = new ArrayList<>();

        for(Blob blob: bucket.list().iterateAll()){
            if(blob.getName().endsWith("mp4")){
                String videoName = blob.getName().toLowerCase();
                if(videoName.contains(searchTerm)){
                    videoNames.add(blob.getName());
                    String url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                            "/o/" + blob.getName() + "?alt=media";
                    videoUrls.add(url);
                }
            }
        }
        displaySearchResults(videoUrls,videoNames);
    }

    private void displaySearchResults(List<String> videoNames, List<String> videoUrls) {
        Stage resultStage = new Stage();
        resultStage.setTitle("Search Results");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        for (int i = 0; i < videoNames.size(); i++) {
            Button videoButton = new Button(videoNames.get(i));
            int index = i;
            videoButton.setOnAction(e -> playVideo(videoUrls.get(index)));
            gridPane.add(videoButton, 0, i);
        }

        ScrollPane scrollPane = new ScrollPane(gridPane);
        Scene scene = new Scene(scrollPane, 400, 400);
        resultStage.setScene(scene);
        resultStage.show();
    }




}


