package com.petadev.dailybucket.entity;

import android.net.Uri;

import java.io.Serializable;
import java.sql.Timestamp;

public final class User implements Serializable {
    private final String userName;
    private final String firstName;
    private final String lastName;
    private final String profilePicture;
    private final Timestamp registeredAt;

    public User(String userName, String firstName, String lastName, String profilePicture, Timestamp registeredAt) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
        this.registeredAt = registeredAt;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Timestamp getRegisteredAt() {
        return registeredAt;
    }
}
