package mike.personalfitnesstracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    void testGettersAndSetters() {
        Person person = new Person("John", "Doe", 25, 180.0, 5, 10);

        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals(25, person.getAge());
        assertEquals(180.0, person.getWeight());
        assertEquals(5, person.getFeet());
        assertEquals(10, person.getInches());

        person.setFirstName("Jane");
        person.setLastName("Smith");
        person.setAge(30);
        person.setWeight(160.0);
        person.setFeet(6);
        person.setInches(2);

        assertEquals("Jane", person.getFirstName());
        assertEquals("Smith", person.getLastName());
        assertEquals(30, person.getAge());
        assertEquals(160.0, person.getWeight());
        assertEquals(6, person.getFeet());
        assertEquals(2, person.getInches());
    }

    @Test
    void testCalcBMI() {
        Person person = new Person("John", "Doe", 25, 180.0, 5, 10);

        // Calculate BMI
        double expectedBMI = 25.82;
        assertEquals(expectedBMI, person.calcBMI(), 0.01);

        // Test with another set of values
        person.setWeight(150.0);
        person.setFeet(5);
        person.setInches(6);

        expectedBMI = 24.22;
        assertEquals(expectedBMI, person.calcBMI(), 0.01);
    }

    @Test
    void testToString() {
        Person person = new Person("John", "Doe", 25, 180.0, 5, 10);

        String expected = "\nFirst Name: John\nLast Name: Doe\nAge: 25\nWeight: 180.0\nFeet: 5\nInches: 10";
        assertEquals(expected, person.toString());
    }
}
