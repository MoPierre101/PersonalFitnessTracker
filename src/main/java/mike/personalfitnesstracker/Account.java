package mike.personalfitnesstracker;

public class Account extends Person {
    private String username;
    private String password;
    private String email;

    private double targetWeight;


    public Account(String username, String password, String email, String firstName, String lastName ,int age, double weight, double height, double targetWeight) {

        super(firstName, lastName, age, weight, height);
        this.username = username;
        this.password = password;
        this.email = email;
        this.targetWeight = targetWeight;

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return super.getFirstName();
    }

    public String getLastName() {
        return super.getLastName();
    }

    public void setFirstName(String firstname) {
        super.setFirstName(firstname);
    }
    public void setLastName(String lastname) {
        super.setLastName(lastname);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return super.getAge();
    }

    public void setAge(int age) {
        super.setAge(age);
    }

    public double getWeight() {
        return super.getWeight();
    }

    public void setWeight(double weight) {
        super.setWeight(weight);
    }

    public double getHeight() {
        return super.getHeight();
    }

    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
    }

    public double getTargetWeight() {
        return this.targetWeight;
    }

}