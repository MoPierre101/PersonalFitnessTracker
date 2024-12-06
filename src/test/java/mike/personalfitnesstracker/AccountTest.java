package mike.personalfitnesstracker;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class AccountTest {

    @Test
    public void testGettersAndSetters() {
        Account account = new Account("user123", "Pass@123", "user@example.com",
                "John", "Doe", 25, 180.0, 5, 10, 170.0);

        assertEquals("user123", account.getUsername());
        assertEquals("Pass@123", account.getPassword());
        assertEquals("user@example.com", account.getEmail());
        assertEquals("John", account.getFirstName());
        assertEquals("Doe", account.getLastName());
        assertEquals(25, account.getAge());
        assertEquals(180.0, account.getWeight());
        assertEquals(5, account.getFeet());
        assertEquals(10, account.getInches());
        assertEquals(170.0, account.getTargetWeight());

        account.setUsername("newUser");
        account.setPassword("NewPass@123");
        account.setEmail("new@example.com");
        account.setFirstName("Jane");
        account.setLastName("Smith");
        account.setAge(30);
        account.setWeight(150.0);
        account.setFeet(6);
        account.setInches(2);
        account.setTargetWeight(140.0);

        assertEquals("newUser", account.getUsername());
        assertEquals("NewPass@123", account.getPassword());
        assertEquals("new@example.com", account.getEmail());
        assertEquals("Jane", account.getFirstName());
        assertEquals("Smith", account.getLastName());
        assertEquals(30, account.getAge());
        assertEquals(150.0, account.getWeight());
        assertEquals(6, account.getFeet());
        assertEquals(2, account.getInches());
        assertEquals(140.0, account.getTargetWeight());
    }

    @Test
    public void testToString() {
        Account account = new Account("user123", "Pass@123", "user@example.com",
                "John", "Doe", 25, 180.0, 5, 10, 170.0);

        String expected = "User Name: user123\nPassword: Pass@123\nEmail: user@example.com"
                + "\nFirst Name: John\nLast Name: Doe\nAge: 25\nWeight: 180.0"
                + "\nFeet: 5\nInches: 10\nTarget Weight: 170.0";
        assertEquals(expected, account.toString());
    }
}