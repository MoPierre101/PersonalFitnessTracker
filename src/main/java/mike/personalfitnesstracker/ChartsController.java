package mike.personalfitnesstracker;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import javafx.event.ActionEvent;
import javafx.scene.chart.*;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ChartsController {

    @javafx.fxml.FXML
    private BorderPane borderPane;

    private List<Log> logs = new LinkedList<>();

    @javafx.fxml.FXML
    public void initialize() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Weight");

        LineChart lineChart = new LineChart(xAxis, yAxis);

        XYChart.Series data = new XYChart.Series();
        data.setName("Weight Overtime");

        ApiFuture<QuerySnapshot> query = Main.fstore.collection("Person")
                .document(CheckInController.docRef)
                .collection("WeightLog")
                .orderBy("Date", Query.Direction.ASCENDING)
                .get();

        try{
            QuerySnapshot querySnapshot = query.get();
            for(DocumentSnapshot document : querySnapshot.getDocuments()) {
                String date = (String) document.getData().get("Date");
                double weight = (Double) document.getData().get("Weight");
                logs.add(new Log(weight, date));
            }

            for(Log log : logs) {
                data.getData().add(new XYChart.Data(log.getDate(), (Double) log.getWeight()));
            }
            lineChart.getData().add(data);
            lineChart.setLegendVisible(false);

            //add barChart to borderPane
            borderPane.setCenter(lineChart);
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
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

        for(Log log : logs) {
            data.getData().add(new XYChart.Data(log.getDate(), (Double) log.getWeight()));
        }

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

        for(Log log : logs) {
            data.getData().add(new XYChart.Data(log.getDate(), (Double) log.getWeight()));
        }

        barChart.getData().add(data);
        barChart.setLegendVisible(false);

        //add barChart to borderPane
        borderPane.setCenter(barChart);
    }

    @javafx.fxml.FXML
    public void handleClose(ActionEvent event) throws IOException {
        SceneManager.switchScene("home.fxml");
    }
}
