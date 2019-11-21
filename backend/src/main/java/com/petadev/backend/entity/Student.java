package com.petadev.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

// Student class, contains data which a student has
// Because this class stores data, it must be final, so we cannot extend it by any means.
// @DatabaseTable denotes that it will become a table in the mysql database when we create it
@DatabaseTable(tableName = "Students")
public final class Student {

    // @DatabaseField denotes it that it will be stored in the database
    // generatedId means that studentId will be generated automatically, also incremented
    @DatabaseField(generatedId = true)
    private int studentId;

    // canBeNull says that we cannot insert an entry with the field being null
    @DatabaseField(canBeNull = false)
    private String firstName;

    @DatabaseField(canBeNull = false)
    private String lastName;

    // unique = true means that there can be only one student with one userName
    // for example if there already is a user with userName "foo"
    // we cannot create another user with the same userName
    @DatabaseField(canBeNull = false, unique = true)
    private String userName;

    @DatabaseField(canBeNull = false)
    private Date birthDate;

    // empty constructor needed by Spring also by OrmLite
    public Student() {
    }


    // constructor used by developer
    public Student(final String firstName, final String lastName, final String userName, final Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }


    public int getStudentId() {
        return studentId;
    }
}
