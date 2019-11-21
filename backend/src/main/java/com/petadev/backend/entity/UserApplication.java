package com.petadev.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "UserApplications")
public final class UserApplication{

    @DatabaseField(generatedId = true)
    private int userApplicationID;

    @DatabaseField(canBeNull = false, foreign = true)
    private User user;

    @DatabaseField(canBeNull = false,foreign = true)
    private Application application;

@DatabaseField(canBeNull = false,foreign = true)
private Date totalTimeSpent;
    public UserApplication() {
    }

    public UserApplication(final User user, final Application application,final Date totalTimeSpent) {
        this.user = user;
        this.application = application;
        this.totalTimeSpent= totalTimeSpent;
    }

    public int getUserApplicationID() {
        return userApplicationID;
    }

    public User getUser() {
        return user;
    }

    public Application getApplication() {
        return application;
    }
public Date getTotalTimeSpent()
{return  totalTimeSpent;}

}

