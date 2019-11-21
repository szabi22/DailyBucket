package com.petadev.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "FinishedUserActivities")
public final class FinishedUserActivity {
    @DatabaseField(generatedId = true)
    private int finishedUserActivityID;

    @DatabaseField(canBeNull = false, foreign = true)
    private User user;

    @DatabaseField(canBeNull = false,foreign = true)
    private Activity activity;

    @DatabaseField(canBeNull = false)
    private Date finishedAt;


    public FinishedUserActivity() {
    }

    public FinishedUserActivity(final User user, final Activity activity,Date finishedAt ) {
        this.user = user;
        this.activity = activity;
        this.finishedAt = finishedAt;
    }

    public int getUserActivityID() {
        return finishedUserActivityID;
    }

    public User getUser() {
        return user;
    }

    public Activity getActivity() {
        return activity;
    }

    public Date getfinishedat() { // Date tipusu valtozo
        return finishedAt;
    }
}//ebbe meg van valmi hiba??

