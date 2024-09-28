module mike.personalfitnesstracker {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens mike.personalfitnesstracker to javafx.fxml;
    exports mike.personalfitnesstracker;
}