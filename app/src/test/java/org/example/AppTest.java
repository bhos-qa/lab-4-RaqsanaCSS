package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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

    // Unit test for concatenate method
    @Test
    public void testConcatenate() {
        assertEquals("hello world", app.concatenate("hello", " world"));
        assertEquals("JavaTest", app.concatenate("Java", "Test"));
    }

    // Unit test for SQL Injection vulnerability
    @Test
    public void testAuthenticateUserSqlInjection() {
        // Simulating a SQL injection scenario
        String username = "admin' --";
        String password = "irrelevant";

        // This should return true for the injected username (simulated behavior)
        boolean isAuthenticated = app.authenticateUser(username, password);

        // Assert that the authentication is successful due to the SQL injection
        assertTrue(isAuthenticated, "SQL Injection should allow authentication.");
    }
}
