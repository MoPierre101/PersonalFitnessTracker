package mike.personalfitnesstracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
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

    final private String[] bc_videoPath = {
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Core/Ab_Crunch.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Core/Bicycle_Crunch.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Core/Mountain_Climbers.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Core/Plank.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Core/Russian_Twist.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Core/Superman.mp4"
    };

    final private String[] bl_videoPath = {
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Lower/Forward_Lunge.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Lower/Farmer's_Carry.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Lower/Dumbbell_Deadlift.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Lower/Dumbbell_Step_Up.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Lower/Single_Leg_Calf_Raise.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Beginner/Lower/Bodyweight_Squat.mp4",
    };

    final private String[] iu_videoPath = {
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Upper/Z_Press.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Upper/Pull_Ups.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Upper/Hammer_Curls.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Upper/Barbell_Bench_Press.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Upper/Dumbbell_Incline_Press.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Upper/Barbell_Bent_Over_Row.mp4"
    };

    final private String[] ic_videoPath = {
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Core/Side_Plank.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Core/V_Sit_Up.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Core/Pallof_Press.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Core/Reverse_Crunch.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Core/Hanging_Leg_Raises.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Core/Barbell_Good_Morning.mp4"
    };

    final private String[] il_videoPath = {
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Lower/Split_Squat.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Lower/Goblet_Squat.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Lower/Romanian_Deadlift.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Lower/Seated_Calf_Raises.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Lower/Barbell_Hip_Thrust.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Lower/Barbell_Front_Squat.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Lower/Barbell_Back_Squat.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Intermediate/Lower/Standing_Barbell_Calf_Raises.mp4"
    };

    final private String[] au_videoPath = {
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Upper/Zottman_Curl.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Upper/Preacher_Curls.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Upper/Military_Press.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Upper/Lateral_Raises.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Upper/Inverted_Rows.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Upper/Pike_Push_Up.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Upper/Clean_And_Press.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Upper/Clapping_Push_Up.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Upper/Incline_Dumbbell_Fly.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Upper/Dumbbell_Skull_Crusher.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Upper/Close_Grip_Lat_Pulldown.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Upper/Wide_Grip_Lat_Pulldown.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Upper/Single_Arm_Landmine_Press.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Upper/Barbell_Incline_Bench_Press.mp4"
    };

    final private String[] ac_videoPath = {
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Core/Burpees.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Core/Side_Plank.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Core/Hollow_Rock.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Core/Medicine_Ball_Slams.mp4"
    };

    final private String[] al_videoPath = {
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Lower/Box_Jumps.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Lower/Seated_Pistols.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Lower/Dumbbell_Lunge.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Lower/Barbell_Lunge.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Lower/Bulgarian_Split_Squats.mp4",
            "src/main/resources/mike/personalfitnesstracker/vids/Advanced/Lower/Burpee_Broad_Jumps.mp4"
    };
    Button playPauseButton;



    @FXML
    public void initialize() {

    }

    //Beginner Options
    @FXML
    private void bu_VidsClicked(ActionEvent event) throws IOException {

        Parent vidsParent = FXMLLoader.load(getClass().getResource("bu_workouts.fxml"));
        Scene vidScene = new Scene(vidsParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(vidScene);
        window.centerOnScreen();
        window.show();


    }
    @FXML
    private void bc_VidsClicked(ActionEvent event) throws IOException {

        Parent vidsParent = FXMLLoader.load(getClass().getResource("bc_workouts.fxml"));
        Scene vidScene = new Scene(vidsParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(vidScene);
        window.centerOnScreen();
        window.show();


    }

    @FXML
    private void bl_VidsClicked(ActionEvent event) throws IOException {

        Parent vidsParent = FXMLLoader.load(getClass().getResource("bl_workouts.fxml"));
        Scene vidScene = new Scene(vidsParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(vidScene);
        window.centerOnScreen();
        window.show();


    }

    //Intermediate Options
    @FXML
    private void iu_VidsClicked(ActionEvent event) throws IOException {

        Parent vidsParent = FXMLLoader.load(getClass().getResource("iu_workouts.fxml"));
        Scene vidScene = new Scene(vidsParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(vidScene);
        window.centerOnScreen();
        window.show();


    }

    @FXML
    private void ic_VidsClicked(ActionEvent event) throws IOException {

        Parent vidsParent = FXMLLoader.load(getClass().getResource("ic_workouts.fxml"));
        Scene vidScene = new Scene(vidsParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(vidScene);
        window.centerOnScreen();
        window.show();


    }

    @FXML
    private void il_VidsClicked(ActionEvent event) throws IOException {

        Parent vidsParent = FXMLLoader.load(getClass().getResource("il_workouts.fxml"));
        Scene vidScene = new Scene(vidsParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(vidScene);
        window.centerOnScreen();
        window.show();


    }

    //Advanced Options
    @FXML
    private void au_VidsClicked(ActionEvent event) throws IOException {

        Parent vidsParent = FXMLLoader.load(getClass().getResource("au_workouts.fxml"));
        Scene vidScene = new Scene(vidsParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(vidScene);
        window.centerOnScreen();
        window.show();


    }

    @FXML
    private void ac_VidsClicked(ActionEvent event) throws IOException {

        Parent vidsParent = FXMLLoader.load(getClass().getResource("ac_workouts.fxml"));
        Scene vidScene = new Scene(vidsParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(vidScene);
        window.centerOnScreen();
        window.show();


    }

    @FXML
    private void al_VidsClicked(ActionEvent event) throws IOException {

        Parent vidsParent = FXMLLoader.load(getClass().getResource("al_workouts.fxml"));
        Scene vidScene = new Scene(vidsParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(vidScene);
        window.centerOnScreen();
        window.show();


    }

    //Back Button Pressed
    @Deprecated
    private void returnClicked(ActionEvent event) throws IOException {

        Parent vidsParent = FXMLLoader.load(getClass().getResource("choicescreen.fxml"));
        Scene vidScene = new Scene(vidsParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(vidScene);
        window.centerOnScreen();
        window.show();


    }
    //Upper Body Beginner Exercise Video Handlers
    @Deprecated
    private void b_uppervid1Clicked(ActionEvent event) throws IOException {
        playVideo(bu_videoPath[0]);
    }
    @Deprecated
    private void b_uppervid2Clicked(ActionEvent event) throws IOException {
        playVideo(bu_videoPath[1]);
    }
    @Deprecated
    private void b_uppervid3Clicked(ActionEvent event) throws IOException {
        playVideo(bu_videoPath[2]);
    }
    @Deprecated
    private void b_uppervid4Clicked(ActionEvent event) throws IOException {
        playVideo(bu_videoPath[3]);
    }
    @Deprecated
    private void b_uppervid5Clicked(ActionEvent event) throws IOException {
        playVideo(bu_videoPath[4]);
    }
    @Deprecated
    private void b_uppervid6Clicked(ActionEvent event) throws IOException {
        playVideo(bu_videoPath[5]);
    }
    @Deprecated
    private void b_uppervid7Clicked(ActionEvent event) throws IOException {
        playVideo(bu_videoPath[6]);
    }
    @Deprecated
    private void b_uppervid8Clicked(ActionEvent event) throws IOException {
        playVideo(bu_videoPath[7]);
    }

    //Core Beginner Exercise Video Handlers
    @Deprecated
    private void b_corevid1Clicked(ActionEvent event) throws IOException {
        playVideo(bc_videoPath[0]);
    }
    @Deprecated
    private void b_corevid2Clicked(ActionEvent event) throws IOException {
        playVideo(bc_videoPath[1]);
    }
    @Deprecated
    private void b_corevid3Clicked(ActionEvent event) throws IOException {
        playVideo(bc_videoPath[2]);
    }
    @Deprecated
    private void b_corevid4Clicked(ActionEvent event) throws IOException {
        playVideo(bc_videoPath[3]);
    }
    @Deprecated
    private void b_corevid5Clicked(ActionEvent event) throws IOException {
        playVideo(bc_videoPath[4]);
    }
    @Deprecated
    private void b_corevid6Clicked(ActionEvent event) throws IOException {
        playVideo(bc_videoPath[5]);
    }

    //Lower Beginner Exercise Video Handlers
    @Deprecated
    private void b_lowervid1Clicked(ActionEvent event) throws IOException {
        playVideo(bl_videoPath[0]);
    }
    @Deprecated
    private void b_lowervid2Clicked(ActionEvent event) throws IOException {
        playVideo(bl_videoPath[1]);
    }
    @Deprecated
    private void b_lowervid3Clicked(ActionEvent event) throws IOException {
        playVideo(bl_videoPath[2]);
    }
    @Deprecated
    private void b_lowervid4Clicked(ActionEvent event) throws IOException {
        playVideo(bl_videoPath[3]);
    }
    @Deprecated
    private void b_lowervid5Clicked(ActionEvent event) throws IOException {
        playVideo(bl_videoPath[4]);
    }
    @Deprecated
    private void b_lowervid6Clicked(ActionEvent event) throws IOException {
        playVideo(bl_videoPath[5]);
    }

    //Upper Intermediate Exercise Video Handlers
    @Deprecated
    private void i_uppervid1Clicked(ActionEvent event) throws IOException {
        playVideo(iu_videoPath[0]);
    }
    @Deprecated
    private void i_uppervid2Clicked(ActionEvent event) throws IOException {
        playVideo(iu_videoPath[1]);
    }
    @Deprecated
    private void i_uppervid3Clicked(ActionEvent event) throws IOException {
        playVideo(iu_videoPath[2]);
    }
    @Deprecated
    private void i_uppervid4Clicked(ActionEvent event) throws IOException {
        playVideo(iu_videoPath[3]);
    }
    @Deprecated
    private void i_uppervid5Clicked(ActionEvent event) throws IOException {
        playVideo(iu_videoPath[4]);
    }
    @Deprecated
    private void i_uppervid6Clicked(ActionEvent event) throws IOException {
        playVideo(iu_videoPath[5]);
    }

    //Core Intermediate Exercise Video Handlers
    @Deprecated
    private void i_corevid1Clicked(ActionEvent event) throws IOException {
        playVideo(ic_videoPath[0]);
    }
    @Deprecated
    private void i_corevid2Clicked(ActionEvent event) throws IOException {
        playVideo(ic_videoPath[1]);
    }
    @Deprecated
    private void i_corevid3Clicked(ActionEvent event) throws IOException {
        playVideo(ic_videoPath[2]);
    }
    @Deprecated
    private void i_corevid4Clicked(ActionEvent event) throws IOException {
        playVideo(ic_videoPath[3]);
    }
    @Deprecated
    private void i_corevid5Clicked(ActionEvent event) throws IOException {
        playVideo(ic_videoPath[4]);
    }
    @Deprecated
    private void i_corevid6Clicked(ActionEvent event) throws IOException {
        playVideo(ic_videoPath[5]);
    }

    //Lower Intermediate Exercise Video Handlers
    @Deprecated
    private void i_lowervid1Clicked(ActionEvent event) throws IOException {
        playVideo(il_videoPath[0]);
    }
    @Deprecated
    private void i_lowervid2Clicked(ActionEvent event) throws IOException {
        playVideo(il_videoPath[1]);
    }
    @Deprecated
    private void i_lowervid3Clicked(ActionEvent event) throws IOException {
        playVideo(il_videoPath[2]);
    }
    @Deprecated
    private void i_lowervid4Clicked(ActionEvent event) throws IOException {
        playVideo(il_videoPath[3]);
    }
    @Deprecated
    private void i_lowervid5Clicked(ActionEvent event) throws IOException {
        playVideo(il_videoPath[4]);
    }
    @Deprecated
    private void i_lowervid6Clicked(ActionEvent event) throws IOException {
        playVideo(il_videoPath[5]);
    }
    @Deprecated
    private void i_lowervid7Clicked(ActionEvent event) throws IOException {
        playVideo(il_videoPath[6]);
    }
    @Deprecated
    private void i_lowervid8Clicked(ActionEvent event) throws IOException {
        playVideo(il_videoPath[7]);
    }

    //Upper Advanced Exercise Video Handlers
    @Deprecated
    private void a_uppervid1Clicked(ActionEvent event) throws IOException {
        playVideo(au_videoPath[0]);
    }
    @Deprecated
    private void a_uppervid2Clicked(ActionEvent event) throws IOException {
        playVideo(au_videoPath[1]);
    }
    @Deprecated
    private void a_uppervid3Clicked(ActionEvent event) throws IOException {
        playVideo(au_videoPath[2]);
    }
    @Deprecated
    private void a_uppervid4Clicked(ActionEvent event) throws IOException {
        playVideo(au_videoPath[3]);
    }
    @Deprecated
    private void a_uppervid5Clicked(ActionEvent event) throws IOException {
        playVideo(au_videoPath[4]);
    }
    @Deprecated
    private void a_uppervid6Clicked(ActionEvent event) throws IOException {
        playVideo(au_videoPath[5]);
    }
    @Deprecated
    private void a_uppervid7Clicked(ActionEvent event) throws IOException {
        playVideo(au_videoPath[6]);
    }
    @Deprecated
    private void a_uppervid8Clicked(ActionEvent event) throws IOException {
        playVideo(au_videoPath[7]);
    }
    @Deprecated
    private void a_uppervid9Clicked(ActionEvent event) throws IOException {
        playVideo(au_videoPath[8]);
    }
    @Deprecated
    private void a_uppervid10Clicked(ActionEvent event) throws IOException {
        playVideo(au_videoPath[9]);
    }
    @Deprecated
    private void a_uppervid11Clicked(ActionEvent event) throws IOException {
        playVideo(au_videoPath[10]);
    }
    @Deprecated
    private void a_uppervid12Clicked(ActionEvent event) throws IOException {
        playVideo(au_videoPath[11]);
    }
    @Deprecated
    private void a_uppervid13Clicked(ActionEvent event) throws IOException {
        playVideo(au_videoPath[12]);
    }
    @Deprecated
    private void a_uppervid14Clicked(ActionEvent event) throws IOException {
        playVideo(au_videoPath[13]);
    }

    //Core Advanced Exercise Video Handlers
    @Deprecated
    private void a_corevid1Clicked(ActionEvent event) throws IOException {
        playVideo(ac_videoPath[0]);
    }
    @Deprecated
    private void a_corevid2Clicked(ActionEvent event) throws IOException {
        playVideo(ac_videoPath[1]);
    }
    @Deprecated
    private void a_corevid3Clicked(ActionEvent event) throws IOException {
        playVideo(ac_videoPath[2]);
    }
    @Deprecated
    private void a_corevid4Clicked(ActionEvent event) throws IOException {
        playVideo(ac_videoPath[3]);
    }

    //Lower Advanced Exercise Video Handlers
    @Deprecated
    private void a_lowervid1Clicked(ActionEvent event) throws IOException {
        playVideo(al_videoPath[0]);
    }
    @Deprecated
    private void a_lowervid2Clicked(ActionEvent event) throws IOException {
        playVideo(al_videoPath[1]);
    }
    @Deprecated
    private void a_lowervid3Clicked(ActionEvent event) throws IOException {
        playVideo(al_videoPath[2]);
    }
    @Deprecated
    private void a_lowervid4Clicked(ActionEvent event) throws IOException {
        playVideo(al_videoPath[3]);
    }
    @Deprecated
    private void a_lowervid5Clicked(ActionEvent event) throws IOException {
        playVideo(al_videoPath[4]);
    }
    @Deprecated
    private void a_lowervid6Clicked(ActionEvent event) throws IOException {
        playVideo(al_videoPath[5]);
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

    @FXML
    public void home(ActionEvent actionEvent) throws IOException{
        SceneManager.switchScene("home.fxml");
    }
}