package com.example.dailybucket;

public final class AuthenticationManager {
    private static boolean LOGGED_IN = false;
    public static String userName = "John Doe";

    public static void logIn(String username, String password) {
        if (username.equals("user1") && password.equals("password123")) {
            LOGGED_IN = true;
        }
    }

    public static void logOut() {
        LOGGED_IN = false;
    }

    public static boolean isLoggedIn() {
        return LOGGED_IN;
    }
}
