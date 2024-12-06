package mike.personalfitnesstracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatternCheckerTest {

    @Test
    public void testIsCorrectEmail() {
        assertTrue(PatternChecker.isCorrectEmail("user@example.com"));
        assertFalse(PatternChecker.isCorrectEmail("userexample.com"));
        assertFalse(PatternChecker.isCorrectEmail("user@.com"));
    }

    @Test
    public void testIsCorrectFirstName() {
        assertTrue(PatternChecker.isCorrectFirstName("John"));
        assertTrue(PatternChecker.isCorrectFirstName("Mary-Jane"));
        assertFalse(PatternChecker.isCorrectFirstName("john"));
        assertFalse(PatternChecker.isCorrectFirstName("Mary Jane"));
    }

    @Test
    public void testIsCorrectWeight() {
        assertTrue(PatternChecker.isCorrectWeight("150"));
        assertTrue(PatternChecker.isCorrectWeight("150.5"));
        assertFalse(PatternChecker.isCorrectWeight("150.555"));
        assertFalse(PatternChecker.isCorrectWeight("abc"));
    }

    @Test
    public void testIsValidPassword() {
        assertTrue(PatternChecker.isValidPassword("Pass@1234"));
        assertFalse(PatternChecker.isValidPassword("password"));
        assertFalse(PatternChecker.isValidPassword("Password123"));
    }
}
