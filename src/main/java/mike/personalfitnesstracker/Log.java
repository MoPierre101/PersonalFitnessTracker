package mike.personalfitnesstracker;

import java.util.Date;

public class Log {
    private double weight;
    private Date date;

    public Log(int weight) {
        this.weight = weight;
        this.date = new Date();
    }

    public double getWeight() {
        return this.weight;
    }

    public Date getDate() {
        return this.date;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDate(Date date) {
        this.date = new Date(date.getTime());
    }

    public String toString() {
        String output = "";
        output += "Weight : " + this.weight + "\n";
        output += "Date : " + this.date + "\n";
        return output;
    }
}
