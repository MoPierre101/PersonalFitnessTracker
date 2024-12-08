package mike.personalfitnesstracker;

public class Account extends Person {
    private String username;
    private String password;
    private String email;

    private double targetWeight;
    private String pfpBlobInfo;

    private boolean darkMode;

    public Account(String username, String password, String email, String firstName, String lastName ,int age, double weight,
                   int ft, int inches, double targetWeight, String pfpBlobInfo) {

        super(firstName, lastName, age, weight, ft, inches);
        this.username = username;
        this.password = password;
        this.email = email;
        this.targetWeight = targetWeight;
        this.pfpBlobInfo = pfpBlobInfo;
        this.darkMode = false;

    }


    public String getPfpBlobInfo(){
        return pfpBlobInfo;
    }

    public void setPfpBlobInfo(String pfpBlobInfo){
        this.pfpBlobInfo = pfpBlobInfo;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;

    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }
    public boolean getDarkMode() {
        return this.darkMode;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    @Override
    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int getFeet() {
        return this.ft;
    }

    @Override
    public void setFeet(int feet) {
        this.ft = feet;
    }

    @Override
    public int getInches() {
        return this.inches;
    }

    @Override
    public void setInches(int inches) {
        this.inches = inches;
    }

    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
    }

    public double getTargetWeight() {
        return this.targetWeight;
    }

    @Override
    public String toString(){
        return "User Name: " + username +
                "\nPassword: " + password +
                "\nEmail: " + email +
                super.toString() +
                "\nTarget Weight: " + targetWeight;
    }
}