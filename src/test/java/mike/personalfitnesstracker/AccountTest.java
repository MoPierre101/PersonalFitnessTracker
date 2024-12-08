package mike.personalfitnesstracker;

import static org.junit.jupiter.api.Assertions.*;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class AccountTest {

    @Test
    public void testGettersAndSetters() {
        Account account = new Account("user123", "Pass@123", "user@example.com",
                "John", "Doe", 25, 180.0, 5, 10, 170.0, "blob_info_123");

        // Test initial values using getters
        assertEquals("user123", account.getUsername());
        assertEquals("Pass@123", account.getPassword());
        assertEquals("user@example.com", account.getEmail());
        assertEquals("John", account.getFirstName());
        assertEquals("Doe", account.getLastName());
        assertEquals(25, account.getAge());
        assertEquals(180.0, account.getWeight(), 0.001);
        assertEquals(5, account.getFeet());
        assertEquals(10, account.getInches());
        assertEquals(170.0, account.getTargetWeight(), 0.001);
        assertEquals("blob_info_123", account.getPfpBlobInfo());

        // Update values using setters
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
        account.setPfpBlobInfo("new_blob_info");

        // Test updated values using getters
        assertEquals("newUser", account.getUsername());
        assertEquals("NewPass@123", account.getPassword());
        assertEquals("new@example.com", account.getEmail());
        assertEquals("Jane", account.getFirstName());
        assertEquals("Smith", account.getLastName());
        assertEquals(30, account.getAge());
        assertEquals(150.0, account.getWeight(), 0.001);
        assertEquals(6, account.getFeet());
        assertEquals(2, account.getInches());
        assertEquals(140.0, account.getTargetWeight(), 0.001);
        assertEquals("new_blob_info", account.getPfpBlobInfo());
    }

    @Test
    public void testToString() {
        Account account = new Account("user123", "Pass@123", "user@example.com",
                "John", "Doe", 25, 180.0, 5, 10, 170.0, "blob_info_123");

        String expected = "User Name: user123\n" +
                "Password: Pass@123\n" +
                "Email: user@example.com\n" +
                "First Name: John\n" +
                "Last Name: Doe\n" +
                "Age: 25\n" +
                "Weight: 180.0\n" +
                "Feet: 5\n" +
                "Inches: 10\n" +
                "Target Weight: 170.0\n" +
                "Profile Picture Info: blob_info_123";
        assertEquals(expected, account.toString());
    }
}