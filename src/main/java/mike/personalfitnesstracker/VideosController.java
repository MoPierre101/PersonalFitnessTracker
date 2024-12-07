package mike.personalfitnesstracker;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;






public class VideosController {
    private MediaPlayer mediaPlayer;
    Button playPauseButton;
    ProgressBar progressBar;
    private Storage storage;
    private Bucket bucket;
    @FXML
    private TextField searchBox;
    @FXML
    private Button bu;
    @FXML
    private Button bc;
    @FXML
    private Button bl;
    @FXML
    private Button iu;
    @FXML
    private Button ic;
    @FXML
    private Button il;
    @FXML
    private Button au;
    @FXML
    private Button ac;
    @FXML
    private Button al;
    private InvalidationListener progressListner;

    private Stage mainStage;
    private Scene mainScene;
    private VBox mainContent;
    private Stack<SceneState> navigationStack = new Stack<>();



    public VideosController() {
        try {
            FileInputStream serviceAccount = new FileInputStream("src/main/resources/mike/personalfitnesstracker/key.json");
            StorageOptions options = StorageOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            this.storage = options.getService();
            this.bucket = storage.get("personal-fitness-tracker-66576.firebasestorage.app");

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    @FXML
    public void initialize() {
        //Loads all videos in Firebase Storage and assigns tags based on folder name.
        ArrayList <String> prefixes = new ArrayList<>(List.of("bu/","bc/","bl/","iu/","ic/","il/","au/","ac/","al/"));
        for(String prefix : prefixes) {
            Page<Blob> blobs = bucket.list(Storage.BlobListOption.prefix(prefix));
            for (Blob blob: blobs.getValues()) {
                if (blob.getName().endsWith(".mp4")) {
                    String tag = prefix.substring(0,prefix.length()-1);
                    Map<String,String> metadata;
                    if (blob.getMetadata() != null) {
                        metadata = new HashMap<>(blob.getMetadata());
                    } else {
                        metadata = new HashMap<>();
                    }
                    metadata.put("type", tag);
                    blob.toBuilder().setMetadata(metadata).build().update(Storage.BlobTargetOption.generationMatch());

                }
            }
        }
        //Initializes search box in choicescreen to run performsearch() on enter being pressed
        searchBox.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                performSearch();
            }
        });
        //Initializes buttons on choicescreen to read through videos in firebase and run setupPage() for access via buttons
        bu.setOnAction(event -> {
            List<String> VideoUrls = new ArrayList<>();
            List<String> VideoNames = new ArrayList<>();
            for (Blob blob : bucket.list().iterateAll()) {
                if (blob.getName().endsWith(".mp4")) {
                    Map<String, String> metadata = blob.getMetadata();
                    if (metadata != null && "bu".equals(metadata.get("type"))) {
                        VideoNames.add(blob.getName());
                        String url = null;
                        try {
                            url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                                    "/o/" + URLEncoder.encode(blob.getName(), "UTF-8") + "?alt=media&token=" + blob.getMetadata().get("firebaseStorageDownloadTokens");
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                        VideoUrls.add(url);
                    }
                }
            }
            setupPage(VideoNames,VideoUrls);
        });
        bc.setOnAction(event -> {
            List<String> VideoUrls = new ArrayList<>();
            List<String> VideoNames = new ArrayList<>();
            for (Blob blob : bucket.list().iterateAll()) {
                if (blob.getName().endsWith(".mp4")) {
                    Map<String, String> metadata = blob.getMetadata();
                    if (metadata != null && "bc".equals(metadata.get("type"))) {
                        VideoNames.add(blob.getName());
                        String url = null;
                        try {
                            url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                                    "/o/" + URLEncoder.encode(blob.getName(), "UTF-8") + "?alt=media&token=" + blob.getMetadata().get("firebaseStorageDownloadTokens");
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                        VideoUrls.add(url);
                    }
                }
            }
            setupPage(VideoNames,VideoUrls);
        });
        bl.setOnAction(event -> {
            List<String> VideoUrls = new ArrayList<>();
            List<String> VideoNames = new ArrayList<>();
            for (Blob blob : bucket.list().iterateAll()) {
                if (blob.getName().endsWith(".mp4")) {
                    Map<String, String> metadata = blob.getMetadata();
                    if (metadata != null && "bl".equals(metadata.get("type"))) {
                        VideoNames.add(blob.getName());
                        String url = null;
                        try {
                            url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                                    "/o/" + URLEncoder.encode(blob.getName(), "UTF-8") + "?alt=media&token=" + blob.getMetadata().get("firebaseStorageDownloadTokens");
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                        VideoUrls.add(url);
                    }
                }
            }
            setupPage(VideoNames,VideoUrls);
        });
        iu.setOnAction(event -> {
            List<String> VideoUrls = new ArrayList<>();
            List<String> VideoNames = new ArrayList<>();
            for (Blob blob : bucket.list().iterateAll()) {
                if (blob.getName().endsWith(".mp4")) {
                    Map<String, String> metadata = blob.getMetadata();
                    if (metadata != null && "iu".equals(metadata.get("type"))) {
                        VideoNames.add(blob.getName());
                        String url = null;
                        try {
                            url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                                    "/o/" + URLEncoder.encode(blob.getName(), "UTF-8") + "?alt=media&token=" + blob.getMetadata().get("firebaseStorageDownloadTokens");
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                        VideoUrls.add(url);
                    }
                }
            }
            setupPage(VideoNames,VideoUrls);
        });
        ic.setOnAction(event -> {
            List<String> VideoUrls = new ArrayList<>();
            List<String> VideoNames = new ArrayList<>();
            for (Blob blob : bucket.list().iterateAll()) {
                if (blob.getName().endsWith(".mp4")) {
                    Map<String, String> metadata = blob.getMetadata();
                    if (metadata != null && "ic".equals(metadata.get("type"))) {
                        VideoNames.add(blob.getName());
                        String url = null;
                        try {
                            url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                                    "/o/" + URLEncoder.encode(blob.getName(), "UTF-8") + "?alt=media&token=" + blob.getMetadata().get("firebaseStorageDownloadTokens");
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                        VideoUrls.add(url);
                    }
                }
            }
            setupPage(VideoNames,VideoUrls);
        });
        il.setOnAction(event -> {
            List<String> VideoUrls = new ArrayList<>();
            List<String> VideoNames = new ArrayList<>();
            for (Blob blob : bucket.list().iterateAll()) {
                if (blob.getName().endsWith(".mp4")) {
                    Map<String, String> metadata = blob.getMetadata();
                    if (metadata != null && "il".equals(metadata.get("type"))) {
                        VideoNames.add(blob.getName());
                        String url = null;
                        try {
                            url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                                    "/o/" + URLEncoder.encode(blob.getName(), "UTF-8") + "?alt=media&token=" + blob.getMetadata().get("firebaseStorageDownloadTokens");
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                        VideoUrls.add(url);
                    }
                }
            }
            setupPage(VideoNames,VideoUrls);
        });
        au.setOnAction(event -> {
            List<String> VideoUrls = new ArrayList<>();
            List<String> VideoNames = new ArrayList<>();
            for (Blob blob : bucket.list().iterateAll()) {
                if (blob.getName().endsWith(".mp4")) {
                    Map<String, String> metadata = blob.getMetadata();
                    if (metadata != null && "au".equals(metadata.get("type"))) {
                        VideoNames.add(blob.getName());
                        String url = null;
                        try {
                            url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                                    "/o/" + URLEncoder.encode(blob.getName(), "UTF-8") + "?alt=media&token=" + blob.getMetadata().get("firebaseStorageDownloadTokens");
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                        VideoUrls.add(url);
                    }
                }
            }
            setupPage(VideoNames,VideoUrls);
        });
        ac.setOnAction(event -> {
            List<String> VideoUrls = new ArrayList<>();
            List<String> VideoNames = new ArrayList<>();
            for (Blob blob : bucket.list().iterateAll()) {
                if (blob.getName().endsWith(".mp4")) {
                    Map<String, String> metadata = blob.getMetadata();
                    if (metadata != null && "ac".equals(metadata.get("type"))) {
                        VideoNames.add(blob.getName());
                        String url = null;
                        try {
                            url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                                    "/o/" + URLEncoder.encode(blob.getName(), "UTF-8") + "?alt=media&token=" + blob.getMetadata().get("firebaseStorageDownloadTokens");
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                        VideoUrls.add(url);
                    }
                }
            }
            setupPage(VideoNames,VideoUrls);
        });
        al.setOnAction(event -> {
            List<String> VideoUrls = new ArrayList<>();
            List<String> VideoNames = new ArrayList<>();
            for (Blob blob : bucket.list().iterateAll()) {
                if (blob.getName().endsWith(".mp4")) {
                    Map<String, String> metadata = blob.getMetadata();
                    if (metadata != null && "al".equals(metadata.get("type"))) {
                        VideoNames.add(blob.getName());
                        String url = null;
                        try {
                            url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                                    "/o/" + URLEncoder.encode(blob.getName(), "UTF-8") + "?alt=media&token=" + blob.getMetadata().get("firebaseStorageDownloadTokens");
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                        VideoUrls.add(url);
                    }
                }
            }
            setupPage(VideoNames,VideoUrls);
        });
        Platform.runLater(this::setMainStage);


    }

    //Video Playback handler
    private void playVideo(String videoPath) {
        saveCurrentState();//Saves state for back button usage

        //Set to use software decoding for video playback
        System.setProperty("prism.order", "sw");
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.dispose();

        }
        if(navigationStack.size() > 1){
            while(navigationStack.size() > 1){
                navigationStack.pop();
            }
        }


        mainContent.getChildren().clear();
        mainContent = new VBox(10);

        playPauseButton = new Button("Pause");
        playPauseButton.setOnAction(e -> togglePlayPause());

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            backButton();
        });

        Media media = new Media(videoPath);
        mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(640);
        mediaView.setFitHeight(480);
        mediaView.setPreserveRatio(true);

        mediaPlayer.statusProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Media Status: " + newValue);
        });
        progressBar = new ProgressBar(0);
        progressListner = (observable) ->{
            if(mediaPlayer.getTotalDuration().toSeconds() > 0)
            {
                double progress = mediaPlayer.getCurrentTime().toSeconds() / mediaPlayer.getTotalDuration().toSeconds();
                Platform.runLater(()-> progressBar.setProgress(progress));
            }

        };
        mediaPlayer.currentTimeProperty().addListener(progressListner);



        mainStage.setTitle("Example Video");
        mainContent.setAlignment(Pos.TOP_CENTER);
        mainContent.setSpacing(15);
        mainContent.getChildren().addAll(mediaView, progressBar, playPauseButton, backButton);
        mainScene = new Scene(mainContent, 640, 480);
        mainStage.setScene(mainScene);

        //Media will start over on end
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
        });

        mediaPlayer.setOnError(() -> {
            System.out.println("Media Status: " + mediaPlayer.getError());
            mediaPlayer.dispose();
            Platform.runLater(()->{
                playVideo(videoPath); // Retry playback
            });

        });

        mediaPlayer.setOnStalled(() -> {
            mediaPlayer.dispose();
            Platform.runLater(()->{
                playVideo(videoPath); // Retry playback
            });
        });

        mediaPlayer.setOnReady(() -> {
            Platform.runLater(() -> {
                mainStage.show();
                mediaPlayer.play();
            });
        });




    }

    //Play\Pause button functionality
    private void togglePlayPause() {
        if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.pause();
            playPauseButton.setText("Play");
        }else {
            mediaPlayer.play();
            playPauseButton.setText("Pause");
        }

    }

    //Takes list of video names and urls made in the initialize and binds them to buttons for access.
    private void setupPage(List <String> names, List <String> urls){
        mainContent.getChildren().clear();
        mainContent = new VBox(10);
        mainContent.setAlignment(Pos.TOP_CENTER);
        for(int i = 0; i < names.size(); i++){
            String videoName = names.get(i).substring(3,names.get(i).length()-4);
            Button button = new Button(videoName);
            int finalI = i;
            button.setOnAction(e -> playVideo(urls.get(finalI)));
            mainContent.getChildren().add(button);

        }
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(mainContent);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        mainScene = new Scene(scrollPane,250,300);
        mainStage.setScene(mainScene);
        mainStage.setTitle("Video Selection");
        mainStage.show();

    }

    //Search bar functionality. Takes input and filters through firebase videos
    private void performSearch(){
        String searchTerm = searchBox.getText().toLowerCase();
        List<String> videoUrls = new ArrayList<>();
        List<String> videoNames = new ArrayList<>();

        for(Blob blob: bucket.list().iterateAll()){
            if(blob.getName().endsWith("mp4")){
                String videoName = blob.getName();
                String url = null;
                if(videoName.toLowerCase().contains(searchTerm)){
                    try {
                        url = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                                "/o/" + URLEncoder.encode(blob.getName(), "UTF-8") + "?alt=media&token=" + blob.getMetadata().get("firebaseStorageDownloadTokens");
                        videoUrls.add(url);
                        videoNames.add(videoName);
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }
        if(!videoUrls.isEmpty()){
            displaySearchResults(videoNames, videoUrls);
        }else{
            mainStage = new Stage();
            mainStage.setTitle("Error");
            mainContent = new VBox();
            mainContent.setAlignment(Pos.CENTER);
            Label errorLabel = new Label("No Results Found");
            mainContent.getChildren().add(errorLabel);
            mainScene = new Scene(mainContent, 150, 100);
            mainStage.setScene(mainScene);
            mainStage.show();
        }
        searchBox.clear();
    }

    //Displays Search Results
    private void displaySearchResults(List<String> videoNames, List<String> videoUrls) {
        mainContent.getChildren().clear();
        mainStage = new Stage();
        mainStage.setTitle("Search Results");
        mainContent = new VBox(10);
        mainContent.setAlignment(Pos.TOP_CENTER);
        for (int i = 0; i < videoNames.size(); i++) {
            Button videoButton = new Button(videoNames.get(i).substring(0, videoNames.get(i).length() - 4));
            int index = i;
            videoButton.setOnAction(e -> playVideo(videoUrls.get(index)));
            mainContent.getChildren().add(videoButton);
        }

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(mainContent);
        scrollPane.setFitToWidth(true);
        mainScene = new Scene(scrollPane, 250, 300);
        mainStage.setScene(mainScene);
        mainStage.show();

    }

    //Initializes main stage
    private void setMainStage(){
        if(bu.getScene() != null){
            mainStage = new Stage();
            mainContent = new VBox(10);
            mainScene = new Scene(mainContent);
            mainStage.setScene(mainScene);
            mainStage.centerOnScreen();
            mainStage.initModality(Modality.APPLICATION_MODAL);
            mainStage.initOwner(bu.getScene().getWindow());
        }

    }
    //Back button implementation. Clears media player and gets properties back from SceneState object.
    private void backButton(){
        if(mediaPlayer != null){
            mediaPlayer.currentTimeProperty().removeListener(progressListner);
            mediaPlayer.stop();
            mediaPlayer.dispose();
            mediaPlayer = null;
            progressBar.setProgress(0);

        }
        mainContent.getChildren().clear();
        mainContent = new VBox(10);
        if(!navigationStack.isEmpty()){
            SceneState previousState = navigationStack.pop();
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(previousState.content);
            scrollPane.setFitToWidth(true);
            mainContent.getChildren().add(scrollPane);
            Scene newScene = new Scene(mainContent, previousState.width, previousState.height);
            mainStage.setTitle(previousState.title);
            mainStage.setScene(newScene);
        }
    }
    //Method saving state and content states to be retrieved and returned to
    private void saveCurrentState(){
        SceneState currentState = new SceneState(
                mainContent,
                mainStage.getTitle(),
                mainStage.getScene().getWidth(),
                mainStage.getScene().getHeight()
        );
        navigationStack.push(currentState);
    }

    //Class for saving and accessing stage and content states for back button functionality
    private class SceneState{
        VBox content;
        String title;
        double width;
        double height;

        //Constructor
        SceneState(VBox content, String title, double width, double height){
            this.content = new VBox(10);
            this.content.getChildren().addAll(content.getChildren());
            this.content.setAlignment(Pos.TOP_CENTER);
            this.content.setSpacing(10);
            this.title = title;
            this.width = width;
            this.height = height;

        }
    }




}


