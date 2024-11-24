package mike.personalfitnesstracker;

import java.util.Date;

public class Log {
    private double weight;
    private String date;

    public Log(double weight, String date) {
        this.weight = weight;
        this.date = date;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getDate() {
        return this.date;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString() {
        String output = "";
        output += "Weight : " + this.weight + "\n";
        output += "Date : " + this.date + "\n";
        return output;
    }
}
