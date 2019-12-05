package com.example.dailybucket;

public final class AuthenticationManager {
    private static boolean LOGGED_IN = true;

    public static void logIn(String username, String password) {
        if (username.equals("username") && password.equals("password")) {
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
