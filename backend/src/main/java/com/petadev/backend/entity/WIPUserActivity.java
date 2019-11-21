package com.petadev.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "WipUserActivities")
public final class WIPUserActivity {
    @DatabaseField(generatedId = true)
    private int wipUserActivityID;

    @DatabaseField(canBeNull = false, foreign = true)
    private User user;

    @DatabaseField(canBeNull = false,foreign = true)
    private Activity activity;

    @DatabaseField(canBeNull = false)
    private Date startedActivityDate;


    public WIPUserActivity() {
    }

    public WIPUserActivity(final User user, final Activity activity,final Date startedActivityDate) {
        this.user = user;
        this.activity = activity;
        this.startedActivityDate = startedActivityDate;
    }

    public int getwipUserActivityID() {
        return wipUserActivityID;
    }

    public User getUser() {
        return user;
    }

    public Activity getActivity() {
        return activity;
    }

    public Date getStartedActivityDate() {
        return startedActivityDate;
    }
}
