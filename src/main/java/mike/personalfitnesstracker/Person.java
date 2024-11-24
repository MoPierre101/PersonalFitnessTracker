package mike.personalfitnesstracker;

public class Person {

    protected String firstName;
    protected String lastName;
    protected int age;
    protected double weight;
    protected int ft;
    protected int inches;

    public Person(String firstName, String lastName ,int age, double weight, int ft, int inches) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;
        this.ft = ft;
        this.inches = inches;
    }

    public Person(Person person) {
        this.lastName = person.lastName;
        this.firstName = person.firstName;
        this.age = person.age;
        this.weight = person.weight;
        this.ft = person.ft;
        this.inches = person.inches;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getFeet() {
        return this.ft;
    }
    public int getInches() {
        return this.inches;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }
    public void setLastName(String name) {
        this.lastName = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setFeet(int ft) {
        this.ft = ft;
    }
    public void setInches(int inches) {
        this.inches = inches;
    }

    public double calcBMI() {

        //convert lbs to kilograms
       double kilograms = weight / 2.2;

       //convert feet to inches and add additional inches
       double totalInches = ((double)ft * 12.0) + inches;

       //convert inches to centimeters to meters
       double meters = (totalInches * 2.54) / 100;

       //formula used to get BMI (kilograms/ meters squared)
       double bmi = kilograms / (Math.pow(meters, 2));

       //round to the 100th decimal point
       return Math.round(bmi * 100.0) / 100.0;

    }

    public String toString(){
        return  "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nAge: " + age +
                "\nWeight: " + weight +
                "\nFeet: " + ft +
                "\nInches: " + inches;
    }
}
