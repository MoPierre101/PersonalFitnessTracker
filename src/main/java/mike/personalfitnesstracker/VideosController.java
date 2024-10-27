package mike.personalfitnesstracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.File;
import java.io.IOException;

public class VideosController {
    private MediaPlayer mediaPlayer;

    final private String[] bu_videoPath = {
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Upper/Cable_Fly.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Upper/Dumbbell_Rows.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Upper/Lat_Pulldown.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Upper/Cable_Face_Pulls.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Upper/Dumbbell_Bicep_Curl.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Upper/Dumbbell_Bench_Press.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Upper/Shoulder_Press.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Upper/Bodyweight_Tricep_Dip.mp4"
    };
    Button playPauseButton;

    @FXML
    private Button bu_Vids;

    @FXML
    private Button intu_Vids;

    @FXML
    private Button au_Vids;

    @FXML
    private Button b_upperVid1;

    @FXML
    private Button b_upperVid2;

    @FXML
    private Button b_upperVid3;

    @FXML
    private Button b_upperVid4;

    @FXML
    private Button b_upperVid5;

    @FXML
    private Button b_upperVid6;

    @FXML
    private Button b_upperVid7;

    @FXML
    private Button b_upperVid8;

    @FXML
    public void initialize() {

    }

    @FXML
    private void bu_VidsClicked(ActionEvent event) throws IOException {

        Parent vidsParent = FXMLLoader.load(getClass().getResource("beginnerworkouts.fxml"));
        Scene vidScene = new Scene(vidsParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(vidScene);
        window.centerOnScreen();
        window.show();


    }

    @FXML
    private void intu_VidsClicked(ActionEvent event) throws IOException {

        Parent vidsParent = FXMLLoader.load(getClass().getResource("intermediateworkouts.fxml"));
        Scene vidScene = new Scene(vidsParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(vidScene);
        window.centerOnScreen();
        window.show();


    }

    @FXML
    private void au_VidsClicked(ActionEvent event) throws IOException {

        Parent vidsParent = FXMLLoader.load(getClass().getResource("advancedworkouts.fxml"));
        Scene vidScene = new Scene(vidsParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(vidScene);
        window.centerOnScreen();
        window.show();


    }

    @FXML
    private void returnClicked(ActionEvent event) throws IOException {

        Parent vidsParent = FXMLLoader.load(getClass().getResource("choicescreen.fxml"));
        Scene vidScene = new Scene(vidsParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(vidScene);
        window.centerOnScreen();
        window.show();


    }
    //Upper Body Beginner Exercise Video Handlers
    @FXML
    private void b_uppervid1Clicked(ActionEvent event) throws IOException {
        playVideo(bu_videoPath[0]);
    }
    @FXML
    private void b_uppervid2Clicked(ActionEvent event) throws IOException {
        playVideo(bu_videoPath[1]);
    }
    @FXML
    private void b_uppervid3Clicked(ActionEvent event) throws IOException {
        playVideo(bu_videoPath[2]);
    }
    @FXML
    private void b_uppervid4Clicked(ActionEvent event) throws IOException {
        playVideo(bu_videoPath[3]);
    }
    @FXML
    private void b_uppervid5Clicked(ActionEvent event) throws IOException {
        playVideo(bu_videoPath[4]);
    }
    @FXML
    private void b_uppervid6Clicked(ActionEvent event) throws IOException {
        playVideo(bu_videoPath[5]);
    }
    @FXML
    private void b_uppervid7Clicked(ActionEvent event) throws IOException {
        playVideo(bu_videoPath[6]);
    }
    @FXML
    private void b_uppervid8Clicked(ActionEvent event) throws IOException {
        playVideo(bu_videoPath[7]);
    }

    private void playVideo(String videoPath) {
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }

        playPauseButton = new Button("Play");
        playPauseButton.setOnAction(e -> togglePlayPause());

        File videoFile = new File(videoPath);
        Media media = new Media(videoFile.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(640);
        mediaView.setFitHeight(480);

        Stage vboxStage = new Stage();
        vboxStage.setTitle("Example Video");
        VBox vbox = new VBox();
        vbox.setAlignment(javafx.geometry.Pos.CENTER);

        vbox.getChildren().addAll(mediaView, playPauseButton);
        Scene vboxScene = new Scene(vbox, 640, 480);
        vboxStage.setScene(vboxScene);
        vboxStage.show();

    }

    private void togglePlayPause() {
        if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.pause();
            playPauseButton.setText("Play");
        }else {
            mediaPlayer.play();
            playPauseButton.setText("Pause");
        }
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
        });

    }

}


