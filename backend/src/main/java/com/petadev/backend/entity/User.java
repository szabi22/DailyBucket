package com.petadev.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.Date;


// Student class, contains data which a student has
// Because this class stores data, it must be final, so we cannot extend it by any means.
@DatabaseTable(tableName = "Users")
public final class User implements Serializable {
    @DatabaseField(generatedId = true)
    private Integer userId;

    @DatabaseField(canBeNull = false, unique = true)
    private String userName;

    @DatabaseField(canBeNull = false)
    private String firstName;

    @DatabaseField(canBeNull = false)
    private String lastName;

    @DatabaseField
    private Date birthDate;

    @DatabaseField
    private Date registerDate;



    @DatabaseField
    private double appTime;

    @JsonIgnore
    @Transient
    @DatabaseField(canBeNull = false)
    private transient String passwordHash;

    // empty constructor needed by Spring
    public User() {
    }

    // constructor used by developer
    public User(final String userName, final String firstName, final String lastName, final Date birthDate, final Date registerDate, final String passwordHash, double appTime) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.registerDate = registerDate;
        this.passwordHash = passwordHash;
        this.appTime = appTime;
    }

    // because fields are private, we need public getters. This way we can't modify our object run-time...
    // we must always create a new instance if data is updated.

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public double getAppTime() {
        return appTime;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
    public int getUserID(){return userId;}
}
