package mike.personalfitnesstracker;

import javafx.event.ActionEvent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;

import java.util.Date;

public class ChartsController {

    @javafx.fxml.FXML
    private BorderPane borderPane;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void handleShowPieChart(ActionEvent actionEvent) {

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
    public void handleClose(ActionEvent actionEvent) {
        System.exit(0);
    }

    @javafx.fxml.FXML
    public void handleUpdateData(ActionEvent actionEvent) {

    }
}
