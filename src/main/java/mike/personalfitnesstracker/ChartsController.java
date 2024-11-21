package mike.personalfitnesstracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class ChartsController {

    @javafx.fxml.FXML
    private BorderPane borderPane;

    private boolean darkmode;

    @javafx.fxml.FXML
    public void initialize() {

        if (darkmode == true) {
            SettingsController.setDarkMode();
        }


        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Weight");

        LineChart lineChart = new LineChart(xAxis, yAxis);

        XYChart.Series data = new XYChart.Series();
        data.setName("Weight Overtime");

        //provide data
        data.getData().add(new XYChart.Data("10/17/24", 134.0));
        data.getData().add(new XYChart.Data("10/18/24", 138.0));
        data.getData().add(new XYChart.Data("10/19/24", 142.0));
        data.getData().add(new XYChart.Data("10/20/24", 146.0));

        lineChart.getData().add(data);
        lineChart.setLegendVisible(false);

        //add barChart to borderPane
        borderPane.setCenter(lineChart);
    }

    @javafx.fxml.FXML
    public void handleShowLineChart(ActionEvent actionEvent) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Weight");

        LineChart lineChart = new LineChart(xAxis, yAxis);

        XYChart.Series data = new XYChart.Series();
        data.setName("Weight Overtime");

        //provide data
        data.getData().add(new XYChart.Data("10/17/24", 134.0));
        data.getData().add(new XYChart.Data("10/18/24", 138.0));
        data.getData().add(new XYChart.Data("10/19/24", 142.0));
        data.getData().add(new XYChart.Data("10/20/24", 146.0));

        lineChart.getData().add(data);
        lineChart.setLegendVisible(false);

        //add barChart to borderPane
        borderPane.setCenter(lineChart);
    }

    @javafx.fxml.FXML
    public void handleShowBarChart(ActionEvent actionEvent) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Weight");

        BarChart barChart = new BarChart(xAxis, yAxis);

        XYChart.Series data = new XYChart.Series();
        data.setName("Weight Overtime");

        //provide data
        data.getData().add(new XYChart.Data("10/17/24", 134.0));
        data.getData().add(new XYChart.Data("10/18/24", 138.0));
        data.getData().add(new XYChart.Data("10/19/24", 142.0));
        data.getData().add(new XYChart.Data("10/20/24", 146.0));

        barChart.getData().add(data);
        barChart.setLegendVisible(false);

        //add barChart to borderPane
        borderPane.setCenter(barChart);
    }

    @javafx.fxml.FXML
    public void handleClose(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(homeScene);
        window.centerOnScreen();
        window.show();
    }

    @javafx.fxml.FXML
    public void handleUpdateData(ActionEvent actionEvent) {
        
    }
}
