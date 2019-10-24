package com.petadev.backend.entity;

import java.util.Date;

// Student class, contains data which a student has
// Because this class stores data, it must be final, so we cannot extend it by any means.
public final class Student {
    private String firstName;
    private String lastName;
    private Date birthDate;

    // empty constructor needed by Spring
    public Student() {
    }

    // constructor used by developer
    public Student(final String firstName, final String lastName, final Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    // because fields are private, we need public getters. This way we can't modify our object run-time...
    // we must always create a new instance if data is updated.

    public Date getBirthDate() {
        return birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
