package mike.personalfitnesstracker;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double weight;
    private double height;

    public Person(String firstName, String lastName ,int age, double weight, double height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public Person(Person person) {
        this.lastName = person.lastName;
        this.firstName = person.firstName;
        this.age = person.age;
        this.weight = person.weight;
        this.height = person.height;
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

    public double getHeight() {
        return this.height;
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

    public void setHeight(double height) {
        this.height = height;
    }

    public String toString(){
        return "First Name: " + this.firstName + "Last Name: " + this.lastName + " Age: " + this.age + " Weight: " +
                this.weight + " Height: " + this.height;
    }
}
