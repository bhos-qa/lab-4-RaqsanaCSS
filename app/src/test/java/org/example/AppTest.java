package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    private App app;

    @BeforeEach
    public void setUp() {
        app = new App();
    }

    // Unit test for sum method
    @Test
    public void testSum() {
        assertEquals(5, app.sum(2, 3));
        assertEquals(0, app.sum(-5, 5));
    }

    // Unit test for isPalindrome method
    @Test
    public void testIsPalindrome() {
        assertTrue(app.isPalindrome("madam"));
        assertFalse(app.isPalindrome("hello"));
    }

    // Unit test for factorial method
    @Test
    public void testFactorial() {
        assertEquals(120, app.factorial(5));
        assertEquals(1, app.factorial(0));
    }

    // Unit test for findMax method
    @Test
    public void testFindMax() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(5, app.findMax(array));
    }

    // Unit test for SQL Injection vulnerability
    @Test
    public void testAuthenticateUserSqlInjection() {
        // This test won't actually interact with a real database, but let's simulate SQL injection testing
        // Normally you should mock the database connection

        // Malicious input simulating an SQL injection
        String username = "admin' --";
        String password = "irrelevant";

        boolean isAuthenticated = app.authenticateUser(username, password);

        // This would simulate the SQL injection passing, which is a vulnerability
        assertTrue(isAuthenticated, "The SQL Injection attack should authenticate the user.");
    }

    // Unit test for concatenate method
    @Test
    public void testConcatenate() {
        assertEquals("hello world", app.concatenate("hello", " world"));
        assertEquals("JavaTest", app.concatenate("Java", "Test"));
    }
}
