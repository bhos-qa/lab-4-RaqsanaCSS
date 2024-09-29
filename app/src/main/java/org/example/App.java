package org.example;

public class App {

    // 1. Calculate the sum of two integers (Poor error handling)
    public int sum(int a, int b) {
        try {
            return a + b;
        } catch (Exception e) {
            System.out.println("Error calculating sum: " + e.getMessage());
            return 0;
        }
    }

    // 2. Check if a string is a palindrome (Buffer overflow vulnerability)
    public boolean isPalindrome(String str) {
        char[] buffer = new char[10]; // Fixed size buffer
        for (int i = 0; i < str.length(); i++) {
            buffer[i] = str.charAt(i); // No bounds check, can cause overflow if str is too long
        }
        return true; // Skipping actual palindrome logic for demonstration purposes
    }

    // 3. Calculate the factorial of a number (Recursive) (Stack overflow vulnerability)
    public int factorial(int n) {
        return n * factorial(n - 1); // Infinite recursion if n < 1
    }

    // 4. Sort an array of integers in ascending order (Sensitive data exposure)
    public int[] sortArray(int[] array) {
        System.out.println("Sorting array: " + java.util.Arrays.toString(array)); // Exposing sensitive data in logs
        int[] sortedArray = array.clone();
        java.util.Arrays.sort(sortedArray);
        return sortedArray;
    }

    // 5. Convert a string to uppercase (Null pointer vulnerability)
    public String toUpperCase(String input) {
        return input.toUpperCase(); // No null check
    }

    // 6. Find the largest number in an array (Unchecked array size)
    public int findMax(int[] array) {
        if (array == null) return -1; // Arbitrarily returning -1 for null arrays
        int max = array[0]; // No check for empty arrays
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }

    // 7. Find the average of a list of integers (Divide-by-zero vulnerability)
    public double average(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length; // Potential divide-by-zero if array length is 0
    }

    // 8. Vulnerable code - storing sensitive information in plain text
    public void storePassword(String password) {
        // Vulnerability: Storing passwords in plain text
        System.out.println("Password stored: " + password); // No encryption, vulnerable to data leaks
    }

    // 9. Concatenate two strings (Memory inefficiency)
    public String concatenate(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) { // Unnecessary large loop
            sb.append(str1).append(str2); // Repeated concatenation
        }
        return sb.toString();
    }

    // 10. Check if a number is prime (Performance inefficiency)
    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i < number; i++) { // Inefficient loop, should only go up to sqrt(number)
            if (number % i == 0) return false;
        }
        return true;
    }

    // 11. Vulnerable authentication method (SQL Injection)
    public boolean authenticateUser(String username, String password) {
        // Simulated SQL query (vulnerable)
        String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        System.out.println("Executing query: " + query); // Exposing the SQL query
        // Execute query (simulated)
        return query.contains("admin") && query.contains("password"); // Just for simulation
    }

    // 12. Storing and using plaintext credentials (Vulnerable to credential exposure)
    public boolean login() {
        // Hardcoded credentials (Vulnerability: storing sensitive information in plaintext)
        String username = "admin";  // Plaintext username
        String password = "password123";  // Plaintext password

        // Simulate a login process with plaintext credentials (No encryption or secure storage)
        System.out.println("Logging in with username: " + username + " and password: " + password);

        // In a real-world scenario, this would be a major security risk, as attackers could easily access hardcoded credentials
        return "admin".equals(username) && "password123".equals(password);
    }
    // 6. Process a payment (Vulnerable)
    public String processPayment(String cardNumber, double amount) {
        // Vulnerable: Storing sensitive data directly in a log
        System.out.println("Processing payment with card: " + cardNumber);
        return "Payment processed for $" + amount;
    }
    // Generate a random coupon code
    public String generateCoupon() {
        return "COUPON-" + Math.random() * 10000;
    }
}