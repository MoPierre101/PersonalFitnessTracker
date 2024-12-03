package mike.personalfitnesstracker;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;



public class VideosController {
    private MediaPlayer mediaPlayer;
    Button playPauseButton;
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
        searchBox.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                performSearch();
            }
        });
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

    }


    private void playVideo(String videoPath) {
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }

        playPauseButton = new Button("Pause");
        playPauseButton.setOnAction(e -> togglePlayPause());

        Media media = new Media(videoPath);
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
        VBox vBox = new VBox(10);

        vBox.setAlignment(Pos.CENTER);
        for(int i = 0; i < names.size(); i++){
            String videoName = names.get(i).substring(3,names.get(i).length()-4);
            Button button = new Button(videoName);
            int finalI = i;
            button.setOnAction(e -> playVideo(urls.get(finalI)));
            vBox.getChildren().add(button);

        }
        ScrollPane scrollPane = new ScrollPane(vBox);
        scrollPane.setFitToWidth(true);
        Stage stage = new Stage();
        stage.setTitle("Video Selection");
        Scene scene = new Scene(scrollPane, 200, 300);
        stage.setScene(scene);
        stage.show();
    }

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
        }
        searchBox.clear();
    }

    private void displaySearchResults(List<String> videoNames, List<String> videoUrls) {
        Stage resultStage = new Stage();
        resultStage.setTitle("Search Results");

        VBox vBox= new VBox(10);

        for (int i = 0; i < videoNames.size(); i++) {
            Button videoButton = new Button(videoNames.get(i).substring(0,videoNames.get(i).length()-4));
            int index = i;
            videoButton.setOnAction(e -> playVideo(videoUrls.get(index)));
            vBox.getChildren().addAll(videoButton);
        }
        vBox.setAlignment(Pos.CENTER);
        ScrollPane scrollPane = new ScrollPane(vBox);
        Scene scene = new Scene(scrollPane, 300, 300);
        resultStage.setScene(scene);
        resultStage.show();
    }




}


