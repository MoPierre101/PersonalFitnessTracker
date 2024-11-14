package mike.personalfitnesstracker;

public class Account  {
    private String username;
    private String password;
    private String email;

    private Person person;

    public Account(String username, String password, String email, Person person) {


        this.username = username;
        this.password = password;
        this.email = email;
        this.person = new Person(person);

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
        return this.person.getFirstName();
    }

    public String getLastName() {
        return this.person.getLastName();
    }

    public void setFirstName(String firstname) {
        this.person.setFirstName(firstname);
    }
    public void setLastName(String lastname) {
        this.person.setLastName(lastname);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return this.person.getAge();
    }

    public void setAge(int age) {
        this.person.setAge(age);
    }

    public double getWeight() {
        return this.person.getWeight();
    }

    public void setWeight(double weight) {
        this.person.setWeight(weight);
    }

    public double getHeight() {
        return this.person.getHeight();
    }

    public Person getPerson() {
        return this.person;
    }
}