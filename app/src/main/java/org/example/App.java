package org.example;

public class App {

    // 1. Calculate the sum of two integers
    public int sum(int a, int b) {
        return a + b;
    }

    // 2. Check if a string is a palindrome
    public boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return cleanStr.equals(new StringBuilder(cleanStr).reverse().toString());
    }

    // 3. Calculate the factorial of a number (Recursive)
    public int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // 4. Sort an array of integers in ascending order
    public int[] sortArray(int[] array) {
        int[] sortedArray = array.clone();
        java.util.Arrays.sort(sortedArray);
        return sortedArray;
    }

    // 5. Convert a string to uppercase
    public String toUpperCase(String input) {
        return input.toUpperCase();
    }

    // 6. Find the largest number in an array
    public int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }

    // 7. Find the average of a list of integers
    public double average(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }

    // 8. Vulnerable code - storing sensitive information in plain text
    public void storePassword(String password) {
        // Vulnerability: Storing passwords in plain text
        System.out.println("Password stored: " + password);
        // Potential risk: Passwords should never be stored or logged in plain text.
    }

    // 9. Concatenate two strings
    public String concatenate(String str1, String str2) {
        return str1 + str2;
    }

    // 10. Check if a number is prime
    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // Method to simulate user authentication (vulnerable to SQL injection)
    public boolean authenticateUser(String username, String password) {
        // Simulated SQL query (vulnerable)
        String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        // Execute query (simulated)
        return query.contains("admin") && query.contains("password"); // Just for simulation
    }
}
