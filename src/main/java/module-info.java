module mike.personalfitnesstracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires google.cloud.firestore;
    requires google.cloud.core;
    requires firebase.admin;
    requires com.google.auth;
    requires com.google.auth.oauth2;
    requires com.google.api.apicommon;
    requires google.cloud.storage;
    requires com.google.common;
    requires gax;
    requires org.testng;


    opens mike.personalfitnesstracker to javafx.fxml;
    exports mike.personalfitnesstracker;
}